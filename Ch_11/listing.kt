import java.util.*
import kotlin.random.Random.Default.nextInt


import java.io.File


val patronGold = mutableMapOf("Eli" to 5.0, "Sophie" to 1.0)
val uniquePatrons = mutableSetOf("Eli" , "Sophie")
var playerGold = 10
var playerSilver = 10

fun main() {


    //Creating a read-only map
    val patronGold = mapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5)
    fun main() {
        println(uniquePatrons)
        var orderCount = 0

        println(patronGold)
    }

    // Defining a map using the Pair type

    val pGold = mapOf(
            Pair("Eli", 10.75),
            Pair("Mordoc", 8.00),
            Pair("Sophie", 5.50)
    )

    // Adding a duplicate key
    val patronGoldduplicated = mutableMapOf("Eli" to 5.0, "Sophie" to 1.0)
    patronGoldduplicated += "Sophie" to 6.0
    println(patronGold)

//  Accessing individual gold balances

    println(patronGold["Eli"])
    println(patronGold["Mordoc"])


//   mutable map
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")

    println(performPurchase(0.3,"Sophie"))
    println(displayPatronBalances())



}

fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

private fun displayPatronBalances() {
    patronGold.forEach { (patron, balance) ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}

