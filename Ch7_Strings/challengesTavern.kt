import java.util.*
import kotlin.random.Random.Default.nextInt

const val TAVERN_NAME = "Taernyl's Folly"

fun main() {

    val phrase = "DRAGON'S BREATH: IT'S GOT WHAT ADVENTURERS CRAVE !"
    println("to dragon speak : Madrigal exclaims: ${toDragonSpeak(phrase)}")

    println("the  item ordered randomly : "+orderWordsRandomly("tea,Dragon’s Breath,5.91"))
}







// Ch7 challenge 1
private fun toDragonSpeak(phrase: String): String =
    phrase.toLowerCase().replace(Regex("[aeiou]")) {

        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }
// Ch7 challenge 2

private fun orderWordsRandomly(menuData: String):String {
    var orderedWords=""

    val data = menuData.split(',')
    val type = data[0]
    val name = data[1]
    val price = data[2]
    var randomInt= (0..3).random()
    if(randomInt == 0){
        orderedWords= data[0]+" "+data[1]+" "+data[2]
        return orderedWords
    }
    else if(randomInt ==1){
        orderedWords= data[1]+" "+data[0]+" "+data[2]
        return orderedWords

    }
    else{
        orderedWords= data[2]+" "+data[0]+" "+data[1]
        return orderedWords

    }

}


