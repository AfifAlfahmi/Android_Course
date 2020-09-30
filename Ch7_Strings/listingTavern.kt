import java.util.*
import kotlin.random.Random.Default.nextInt

const val TAVERN_NAME = "Taernyl's Folly"
fun main() {

// Extracting the tavern master’s name
    placeOrder()



    // Splitting the menu data
    orderSplit("tea,Dragon's Breath,5.9")


    //  Destructuring the menu data
    println("Destructuring the menu : "+placeOrderDestructuring("tea,Dragon's Breath,5.9"))

//   String Comparison
   val name ="Dragon's Breat"
    val phrase: String = if (name == "Dragon's Breath") {
        "Madrigal exclaims ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "Madrigal says: Thanks for the $name."
    }
    println(phrase)
}


private fun placeOrder() {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")
}

private fun orderSplit(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    val data = menuData.split(',')
    val type = data[0]
    val name = data[1]
    val price = data[2]
    val message = " Split the menu : Madrigal buys a $name ($type) for $price."
    println(message)
}


private fun placeOrderDestructuring(menuData: String):String {


    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price."
    return message
}

private fun toDragonSpeak(phrase: String): String =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }