import java.util.*
import kotlin.random.Random.Default.nextInt


import java.io.File




fun main() {
    //Instantiating a Player

    val player = Player()
    player.castFireball()
    // Aura

   println( player.auraColor(player.isBlessed,player.healthPoints,player.isImmortal))

    println("(Aura: ${player.auraColor(player.isBlessed,player.healthPoints,player.isImmortal)}) " +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")


}

// Defining a custom getter (P
class Player {
    var name = "madrigal"
        //Defining a custom getter
        get() = field.capitalize()

        //Defining a custom setter
        // Hiding name’s setter
       private set(value) {
            field = value.trim()
        }
    var healthPoints = 89
    val isBlessed = true
     val isImmortal = false

    //  Defining a computed property


    val rolledValue
        get() = (1..6).random()

     fun auraColor(
            isBlessed: Boolean,
            healthPoints: Int,
            isImmortal: Boolean
    ): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }
     fun formatHealthStatus(): String =
            when (healthPoints) {
                100 -> "is in excellent condition!"
                in 90..99 -> "has a few scratches."
                in 75..89 -> if (isBlessed) {
                    "has some minor wounds, but is healing quite quickly!"
                } else {
                    "has some minor wounds."
                }
                in 15..74 -> "looks pretty hurt."
                else -> "is in awful condition!"
            }




    fun castFireball(numFireballs: Int = 2) {
        println("A fireball springs into existence. (x$numFireballs)")
    }
}
