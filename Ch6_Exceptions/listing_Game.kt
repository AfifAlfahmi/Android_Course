import java.util.*
import kotlin.random.Random.Default.nextInt


fun main() {

    // Defining a nullable variable
    println("enter a number")
    var beverage = readLine()
    println(beverage)
// Using the safe call operator
    println("enter a number again to check safe call operator")

    var beage = readLine()?.capitalize()
    beverage = null
    println(beage)


    //Using let with the safe call operator
    println("enter a number again to check safe call operator with let")

    var beverage2 = readLine()?.let {
        if (it.isNotBlank()) {
            it.capitalize()
        } else {
            "Cream Soda"
        }
    }
    println("enter a number again to check double-bang operator")

    //   Using the double-bang operator
    var beverage3 = readLine()!!.capitalize()

       beverage = null
    println(beverage)

    // Using != null for null checking
    if (beverage != null) {
        beverage = beverage.capitalize()
    } else {
        println("I can't do that without crashing - beverage was null!")
    }
    println(beverage)

// Using the null coalescing operator


    val beverageServed: String = beverage ?: "Cream Soda"
    println(beverageServed)

    //

    var swordsJuggling: Int? = null
    val isJugglingProficient = (0..3).random() == 0
    if (isJugglingProficient) {
        swordsJuggling = 2
    }
    proficiencyCheck(swordsJuggling)
    swordsJuggling = swordsJuggling!!.plus(1)
    println("You juggle $swordsJuggling swords!")
8
    // try/ catch

    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }

}


//  Throwing an  IllegalStateException

fun proficiencyCheck(swordsJuggling: Int?) {
    swordsJuggling ?: throw IllegalStateException("Player cannot juggle swords")
}



