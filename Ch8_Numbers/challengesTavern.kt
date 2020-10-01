import java.util.*
import kotlin.random.Random.Default.nextInt

const val TAVERN_NAME = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 1

fun main() {


    println(" the number of pints left in the barrel = "+performPurchase(4.2))
    performPurchaseHandlingNegative(1.2)
    println("Remaining Balance In DragonCoin = "+dragoncoin(5.91))





}


//Ch 8 Challenge 1
fun performPurchase(price: Double):Double {
    var barrelGallons =5;
    var remainingGallons=barrelGallons- (0.125*12)

    var remainingPints= (remainingGallons/0.125)
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")
    val remainingBalance = totalPurse - price
    return remainingPints
}
//Ch 8 Challenge 2
fun performPurchaseHandlingNegative (price: Double):Double {

    val totalPurse = playerGold + (playerSilver / 100.0)
    var remainingBalance = totalPurse
    if(totalPurse >=price){
        remainingBalance = remainingBalance - price
println("Madrigal buys a Dragon’s Breath (tea) for $price")
    }
    else{
        println("customer is short on gold")

    }


    return remainingBalance
}
//Ch 8 Challenge 3

fun dragoncoin(price:Double):Double{
    var playerBalanceInDragonCoin=5

    var  newBalanceInDragonCoin=  playerBalanceInDragonCoin - price/1.43


    return newBalanceInDragonCoin
}










