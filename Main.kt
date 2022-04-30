package machine

import kotlin.math.min

fun main() {
    menu()
}
//class coffeeMachine {
//    fun taker(input: String) {
//
//    }
//}
fun menu() {

    var water = 400
    var milk = 540
    var coffeeBeans = 120
    var cups = 9
    var money = 550

    while (true) {
        var lack = ""
        print("Write action (buy, fill, take, remaining, exit): ")
        when (readLine()!!) {
            "buy" -> {
                print(
                    "\nWhat do you want to buy? 1 - espresso, 2 - latte, " +
                            "3 - cappuccino, back - to main menu: "
                )
                when (readLine()!!) {
                    "1" -> {
                        if (water < 250) lack = "water" else if (coffeeBeans < 16)
                            lack = "coffeeBeans" else if (cups < 1) lack = "cups"
                        else {
                            println("I have enough resources, making you a coffee!\n")
                            water -= 250
                            coffeeBeans -= 16
                            cups--
                            money += 4
                        }
                    }
                    "2" -> {
                        if (water < 350) lack = "water" else if (milk < 75) lack = "milk"
                        else if (coffeeBeans < 20) lack = "coffeeBeans"
                        else if (cups < 1) lack = "cups"
                        else {
                            println("I have enough resources, making you a coffee!\n")
                            water -= 350
                            milk -= 75
                            coffeeBeans -= 20
                            cups--
                            money += 7
                        }
                    }
                    "3" -> {
                        if (water < 200) lack = "water" else if (milk < 100) lack = "milk"
                        else if (coffeeBeans < 12) lack = "coffeeBeans"
                        else if (cups < 1) lack = "cups"
                        else {
                            println("I have enough resources, making you a coffee!\n")
                            water -= 200
                            milk -= 100
                            coffeeBeans -= 12
                            cups--
                            money += 6
                        }
                    }
                    "back" -> continue
                }
            }
            "fill" -> {
                print("Write how many ml of water do you want to add: ")
                water += readln().toInt()
                print("Write how many ml of milk do you want to add: ")
                milk += readln().toInt()
                print("Write how many grams of coffee beans do you want to add: ")
                coffeeBeans += readln().toInt()
                print("Write how many disposable cups of coffee do you want to add: ")
                cups += readln().toInt()
            }
            "take" -> {
                println("I gave you \$$money\n")
                money = 0
            }
            "remaining" -> state(water, milk, coffeeBeans, cups, money)
            "exit" -> break
        }
        if (lack != "") println("Sorry, not enough $lack!")
    }
}

fun state(water: Int, milk: Int, coffeeBeans: Int, cups: Int, money: Int) {
    println(
        "\nThe coffee machine has:\n" +
                "$water ml of water\n" +
                "$milk ml of milk\n" +
                "$coffeeBeans g of coffee beans\n" +
                "$cups disposable cups\n" +
                "\$$money of money\n"
    )
}