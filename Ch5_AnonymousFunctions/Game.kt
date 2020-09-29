import java.util.*

import kotlin.random.Random.Default.nextInt


fun main() {




// chapter 5 listing

    // Defining an anonymous greeting function

    println(
            {
                val currentYear = 2018
                "Welcome to SimVillage, Mayor! (copyright $currentYear)"
            }()
    )
    //   Assigning the anonymous function to a variable
    val greetingFunction: () -> String = {
        val currentYear = 2018
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
    }
// one Parameter anonymous  Fun
    val oneParameterFun: (String) -> String = { playerName ->
        val currentYear = 2018
        "Welcome to SimVillage, Mayor! (copyright $currentYear)"
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
    println(greetingFunction())
    println(oneParameterFun("Afif"))

// Using the it keyword
    val plName="Afif"

    val greetFunction: (String) -> String = {
        val currentYear = 2018
        "Welcome to SimVillage, $plName! (copyright $currentYear)"
        "greeting using it keyword, $it! (copyright $currentYear)"
    }
    println(greetFunction("Alfahmi"))
    println(runSimulation())

    // calls to   challenges function

    println("Ch5 challenges")

    println("the sum of two  int = "+sum(4,3))
    println(name("Afif",allInfo))


}




// function that configures the arguments for the lambda

fun runSimulation() {
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("Afif"))
}
fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2018
        numBuildings += 1
        println("using function that configures the arguments" +
                " Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName! (copyright $currentYear)"
    }
}




//   Chapter 5 challenges

//      anonymous function that takes two integers and calculate the sum



val sum: (Int,Int) -> Int =  {x,y ->

    x + y}

//   anonymous function that takes another function , then  inline the function



val allInfo = { firstName: String, lastName: String ->
    val address="Riyadh"

    "first Name $firstName  lastName $lastName!  Address $address! )"
}

inline fun name(fName:String, allInfo:(String, String) -> String) {



    var lastName="Alfahmi"
    println(allInfo(fName, lastName))
}










