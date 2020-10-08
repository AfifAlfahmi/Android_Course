import java.io.File

const val TAVERN_NAME = "Tearnyl's Folly"

val menuList = File("data/tavern-menu-items.txt").readText().split("-")


val patronList: List<String> = listOf("Eli", "Mordoc", "Sophie","Afif")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins","Alfahmi")


val uniquePatrons: Set<String> = generateSequence {

    val first = patronList.random()
    val last = lastName.random()
    "$first $last" }.distinct()
        .take(9).toSet()


val patronGold:MutableMap<String,Double> = (uniquePatrons.associateWith { 6.0 } .toMutableMap())


var dBreathRemainingAmount:Float = 5.0F
var numOfPints = 40
var numOfPintsSold = 0

fun main() {
    println(uniquePatrons)
    println(patronGold)
    val eliMessage = if (patronList.contains("Eli")){
        "The tavern master says: Eli's in the back playing cards"
    } else {
        "The tavern master says: Eli's isn't here"
    }
    println(eliMessage)

    val otherMessage = if(patronList.containsAll(listOf("Sophie","Mordoc"))){
        "The tavern master says: Yea, they'r seated by the stew kettle"
    } else {
        "The tavern master says: Nay, they departed hours ago"
    }
    println(otherMessage)




    var orderCount = 0
    while(orderCount <= 9){
        if(uniquePatrons.isNotEmpty()) {
            placeOrder(
                    uniquePatrons.random(),
                    menuList.random()
            )
        }

        orderCount++


    }

    displayPatronBalances()
    println("Dragon Does Speak".toDragonSpeak())

}



private fun displayPatronBalances(){
    patronGold.forEach{ (patron, balance) ->
        println("$patron, balance: ${"%.2f".format(balance)}")

    }
}
private fun String.toDragonSpeak(): String =
        this.replace(Regex("[aeiouAEIOU]")){
            when (it.value){
                "a" , "A" -> "4"
                "e" ,  "E"-> "3"
                "i","I" -> "1"
                "o" ,"O"-> "0"
                "u","U" -> "!_!"
                else -> it.value
            }
        }

fun performPurchase(price: Double, patronName: String): Boolean{
    val totalPurse = patronGold.getValue(patronName)

    if(totalPurse <= 0.0){

        patronGold.remove(patronName)
        println("$patronName got kicked out to  the mean streets of NyetHack due to not having gold!")
    }
    if (totalPurse - price > 0){
        patronGold[patronName] = totalPurse - price
        return true
    }
    else return false
}

private fun placeOrder(patronName:String , menuData:String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName speaks with $tavernMaster about their order")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price"
    println(message)
    var purchaseSuccess = performPurchase(price.toDouble(), patronName)
    if (name == "Dragon's Breath" && purchaseSuccess) {
        dBreathRemainingAmount -= 0.125f
        numOfPints--
        numOfPintsSold++
        if (numOfPintsSold == 12) {
            println("The remaining pints of dragon's breath is $numOfPints pints")
            println(dBreathRemainingAmount)
        }
    }


    val phrase: String = if (name.toLowerCase() == "Dragon's Breath".toLowerCase() && purchaseSuccess) {
        "$patronName exclaims ${("Ah, delicious $name!").toDragonSpeak()}"
    } else {
        "$patronName says: Thanks for $name"
    }
    println(phrase)


}

private fun randomOrder(phrase:String): String{
    val randomOrder = phrase.split(',')
    val randomizedOrder = randomOrder.shuffled().take(phrase.length)
    val randomPhrase = randomizedOrder.joinToString()
    return randomPhrase

}

private fun advancedFormattedMenu(){
    var paddingLimit = menuList.maxBy { it.length }?.length ?: 0
    val setOfTypes = mutableSetOf<String>()
    menuList.forEach {
        val (type, name, price) = it.split(',')
        setOfTypes += type
    }
    println("*** Welcome to Taernyl's Folly ***")
    for(type in setOfTypes){
        println("        ~[$type]~")
        menuList.forEach{
            formattedItem(it , paddingLimit, type)
        }
    }


}

private fun formattedItem(item:String , padding:Int ,typeOfItem:String){
    val (type, name, price) = item.split(',')
    var requiredPadding =  padding - (name.length  + price.length)
    var paddingDots:String = "."
    if(typeOfItem == type) {
        while (requiredPadding > 1) {
            paddingDots += "."
            requiredPadding--
        }

        val capitalizedName = name.split(" ").map { it.toLowerCase().capitalize() }.joinToString(" ")
        val itemInMenu = capitalizedName + paddingDots + price
        println(itemInMenu)
    }
}

