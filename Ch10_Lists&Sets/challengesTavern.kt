import java.util.*
import kotlin.random.Random.Default.nextInt



fun main() {

    // call functions
    println(formattedTavernMenu())
    println(advancedFormattedTavernMenu())
}


// Ch 10 challenge 1

fun  formattedTavernMenu (){
println("*** Welcome to Taernyl's Folly ***")
    val patronListPrice = listOf(5.91, 4.1 , 1.22, 7.33, 11.22)
    val patronList = listOf("dragon's breath", "shirley temple","goblet of laCroix","pickled latt","lced coffee")
    var maxItemLength = 0
    for (item in patronList) {
        var itemStr: String = item.toString()
        var itemlength = itemStr.length
        if (itemlength > maxItemLength) {
            maxItemLength = itemlength
        }

    }
    patronList.forEachIndexed { index, data ->



        println(String.format("%-18s .............. %s",  patronList[index.toInt()].capitalize(), patronListPrice[index.toInt()]))

    }


}


// Ch 10 challenge 2
fun  advancedFormattedTavernMenu (){

    println("*** Welcome to Taernyl's Folly ***")

    val patronListPrice = listOf(5.91, 4.1 , 1.22, 7.33, 11.22)
    val patronList = listOf("dragon's breath", "shirley temple","goblet of laCroix","pickled latt","lced coffee")
    val patronListTypes = listOf("tea", "elixir" ,"coffe", "meal", "desert dessert")

    patronList.forEachIndexed { index, data ->

        var currentStrlen=data.length
        println("           ~"+patronListTypes[index.toInt()]+"~" )
        println(String.format("%-18s .............. %s",  patronList[index.toInt()].capitalize(), patronListPrice[index.toInt()]))


    }


}