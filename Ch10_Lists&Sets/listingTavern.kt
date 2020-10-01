import java.util.*
import kotlin.random.Random.Default.nextInt



const val TAVERN_NAME = "Taernyl's Folly"
var playerGold = 10
var playerSilver = 10

//   Creating a list of patrons
val patronList: List<String> = listOf("Eli", "Mordoc", "Sophie")

fun main() {

    println("patron lis is "+patronList)

    //Accessing the first patron
    println("first item in patron list is "+patronList[0])
// Accessing the last patron
    patronList.last()

//  Checking for a patron
    val eliMessage = if (patronList.contains("Eli")) {
        "The tavern master says: Eli's in the back playing cards."
    } else {
        "The tavern master says: Eli isn't here."
    }
    println("yes  eliMessage is  "+eliMessage)

    // Making the patron list mutable

    val patronList = mutableListOf("Eli", "Mordoc", "Sophie")

    patronList.remove("Eli")
    patronList.add("Alex")

   // Iterating over the patronList with for
println(" print patron list using for ")
    for (patron in patronList) {
        println("Good evening, $patron")
    }

    //  Iterating over the patronList with forEach
    println(" print patron list using forEach ")

    patronList.forEach { patron ->
        println("Good evening, $patron")
    }
    // for Each Indexed
println(     " Iterating over the patronList with forEachIndexed")
    patronList.forEachIndexed { index, patron ->
        println("Good evening, $patron - you're #${index + 1} in line.")

    }

    //    Sets

    //Creating a set
    val planets = setOf("Mercury", "Venus", "Earth", "Earth")

    // Checking planets

    println("check plants if contain Earth"+planets.contains("Earth"))

    // Finding the second  planet
    planets.elementAt(1)


    //  Ensuring uniqueness using a set
    val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
    val uniquePatrons = mutableSetOf<String>()

    repeat(10) {
        val first = patronList.random()
        val last = lastName.random()
        val name = "$first $last"
        println(name)
        uniquePatrons += name
    }
    println(" the unique Patrons"+uniquePatrons)

    // Converting a list to a se
    listOf("Eli Baggins", "Eli Baggins", "Eli Ironfoot").toSet()

    // Calling distinct

    val patrons = listOf("Eli Baggins", "Eli Baggins", "Eli Ironfoot").distinct()

   println( "first item of patron list is "+patrons[0])
}


