import java.util.*
import kotlin.random.Random.Default.nextInt


import java.io.File




fun main() {


    // ch13 challenge 1

    //Referencing name (REPL)
    val sword = Sword("Excalibur")
    println(sword.name)
    // Ans     The Legendary Excalibur


    // Reassigning name (REPL)
    sword.name = "Gleipnir"
    println(sword.name)
// Ans:  The Legendary Rinpielg

    //Adding an initializer block & Referencing name
    val sword2 = Sword2("Excalibur")
    println(sword2.name)
// Ans:  The Legendary Rubilacxe


    // challenge 2 Health Points Range

    val player = Player("Afif",44,true,false,"")

    println("player healthPoints = "+player.healthPoints)

    // challenge 3  Hometown Mess

    println("Town name from file is "+player.townName)


}

// ch13 challenge 1

class Sword(_name: String) {
    var name = _name
        get() = "The Legendary $field"
        set(value) {
            field = value.toLowerCase().reversed().capitalize()
        }
}








//   Adding an initializer block (REPL)
class Sword2(_name: String) {
    var name = _name
        get() = "The Legendary $field"
        set(value) {
            field = value.toLowerCase().reversed().capitalize()
        }
    init {
        name = _name
    }
}


// Ch13 challenge 2 & 3

class Player(
        _name: String,
        var healthPoints: Int ,
        val isBlessed: Boolean,
        private val isImmortal: Boolean,
        private var _townName:String
) {
    var name = _name

        var townName=_townName
        get() = " $hometown"

        private set(value) {
            field = value.trim()
        }
    private val hometown by lazy { selectHometown() }

    private fun selectHometown() = File("C:/Users/afef2/IdeaProjects/NyetHack/src/data/towns.txt")
            .readText()
            .substring(0,5)




    init {
        require(healthPoints in 40..100) { "healthPoints must be in range from 40 to 100 ." }

    }


}