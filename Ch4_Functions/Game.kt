import java.util.*

import kotlin.random.Random.Default.nextInt


fun main() {

    val name = "Madrigal"
    var healthPoints = 89
    var isBlessed = true
    val isImmortal = false
// Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)
// Player status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    performCombat()
    performCombat("Ulrich")
    performCombat("Hildr", true)

println("Chapter 4 challenges ")

    println("aura Color Single Expression  "+auraColorSingleExpr(isBlessed,healthPoints,isImmortal))

    println("remaining fuel value = "+castFireballFuel(20))
    println("Fuel Status is" +fuelStatus())





}

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
    val healthStatus = when (healthPoints) {
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
    return healthStatus
}
private fun printPlayerStatus(
        auraColor: String,
        isBlessed: Boolean,
        name: String,
        healthStatus: String
) {
    println("(Aura: $auraColor) " +
            "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

private fun auraColor(
        isBlessed: Boolean,
        healthPoints: Int,
        isImmortal: Boolean
): String {
    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    return auraColor
}




private fun castFireball(numFireballs: Int = 2) {
    println("A fireball springs into existence. (x$numFireballs)")
}

fun performCombat() {
    println("You see nothing to fight!")
}
fun performCombat(enemyName: String) {
    println("You begin fighting $enemyName.")
}
fun performCombat(enemyName: String, isBlessed: Boolean) {
    val combatMessage: String = if (isBlessed) {
        "You begin fighting $enemyName. You are blessed with 2X damage!"
    } else {
        "You begin fighting $enemyName."
    }
    println(combatMessage)
}

  // challenges

//  Single-Expression Functions


private fun auraColorSingleExpr(isBlessed: Boolean,healthPoints: Int, isImmortal: Boolean): String =

        when(isBlessed && healthPoints > 50 || isImmortal){
            true ->  "GREEN"
            else -> "NONE"
        }


//

private fun castFireballFuel(numFireballs: Int = 2):Int {
    println("A fireball springs into existence. (x$numFireballs)")
    return 50-numFireballs

}

//

private fun fuelStatus():String {
    var fuelValue=castFireballFuel(20)

  val fuelStatus= when(fuelValue){
      in 1..10 -> "empty"
      in 11..20 ->"fumes"
      in 21..30 -> "low"
      else ->"full"

  }
return fuelStatus
}

















