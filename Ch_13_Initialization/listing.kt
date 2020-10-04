import java.util.*
import kotlin.random.Random.Default.nextInt


import java.io.File




fun main() {

// , instantiating Player

    val player = Player("Madrigal", 89, true, false)

   // Calling a secondary constructor
    val player2 = Player("Madrigal")

    println("player with main constructor  name "+player.name +"player health point "+player.healthPoints +"  is Blessed "+player.isBlessed
    +" isImmortal "+player.isImmortal)

    println("player with secondary constructor  name  "+player2.name +"player health point "+player2.healthPoints +"  is Blessed "+player2.isBlessed
            +" isImmortal "+player2.isImmortal)

}

class Player(
        _name: String,
        var healthPoints: Int = 100,
        val isBlessed: Boolean,
         val isImmortal: Boolean
) {

    var name = _name
        get() = field.capitalize()
        private set(value) {
            field = value.trim()
        }

    lateinit var alignment: String



    init {
        require(healthPoints > 0) { "healthPoints must be greater than zero." }
        require(name.isNotBlank()) { "Player must have a name." }
    }
    constructor(name: String) : this(
            name,

            isBlessed = true,
            isImmortal = false
    ) {
        if (name.toLowerCase() == "kar") {
            healthPoints = 40
        }
    }
}