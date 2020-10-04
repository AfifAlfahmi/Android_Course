import java.util.*
import kotlin.random.Random.Default.nextInt


import java.io.File


val patronGold = mutableMapOf("Eli" to 5.0, "Sophie" to 1.0)
val uniquePatrons = mutableSetOf("Eli" , "Sophie")
var playerGold = 10
var playerSilver = 10

fun main() {
    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }

    println(tavernBouncer(8.3,"Eli"))












}

fun tavernBouncer(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    if(totalPurse < price){
        println("patron Gold before purchase")
        println(patronGold)
        println("unique Patrons  before purchase")
        println(uniquePatrons)

        patronGold.remove(patronName)
        uniquePatrons.remove(patronName)
        println(patronName+" lacks sufficient funds, patron Gold after remove "+patronName)

        println(patronGold)
        println("unique patron  after remove "+patronName)

        println(uniquePatrons)

    }
    else{
        patronGold[patronName] = totalPurse - price
    }

}


