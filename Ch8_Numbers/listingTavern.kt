import java.util.*
import kotlin.random.Random.Default.nextInt

const val TAVERN_NAME = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10

fun main() {


println(performPurchase(9.2))

   

    println(placeOrder("tea,Dragon's Breath,5.9"))
}
  // Passing the price information

fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")
    val remainingBalance = totalPurse - price

    //   Formatting a double


    println("Remaining balance: ${"%.2f".format(remainingBalance)}")
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
}



     // Converting the price argument to a double
private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")
    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    println(message)
    performPurchase(price
        .toDouble()
    )

}