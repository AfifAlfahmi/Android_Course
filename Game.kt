


fun main() {

// Listing

    // if-else
    val pName = "Madrigal"
    var hPoints = 89
    if (hPoints >= 15) {
// Triggered for any value of 15 or higher
        println(pName + " looks pretty hurt.")
    } else if (hPoints >= 75) {
        println(pName + " has some minor wounds.")
    } else if (hPoints >= 90) {
        println(pName + " has a few scratches.")
    } else if (hPoints == 100) {
        println(pName + " is in excellent condition!")
    } else {
        println(pName + " is in awful condition!")
    }

    ////////


    val isBles = true
    val healthStatus: String = if (hPoints == 100) "is in excellent condition!"
    else if (hPoints >= 90) "has a few scratches."
    else if (hPoints >= 75)
        if (isBles) "has some minor wounds but is healing quite quickly!"
        else "has some minor wounds."
    else if (hPoints >= 15) "looks pretty hurt."
    else "is in awful condition!"
    println(healthStatus)


    // when  Expressions

    val race = "gnome"
    val faction: String = when(race) {
        "dwarf" -> "Keepers of the Mines"
        "gnome" -> "Keepers of the Mines"
        "orc" -> "Free People of the Rolling Hills"
        "human" -> "Free People of the Rolling Hills"
        else ->"none"
    }
    println("the faction is "+faction)




    //Challenge: Trying Out Some Ranges

    println("Trying Out Some Ranges Challenge ")

    println("1 in 1..3 = "+(1 in 1..3))
    println("(1..3).toList() = "+(1..3).toList())
    println("1 in 3 downTo 1 = "+(1 in 3 downTo 1))
    println("1 in 1 until 3 = "+(1 in 1 until 3))
    println( "3 in 1 until 3 = "+(3 in 1 until 3))
    println("2 in 1..3 = "+(2 in 1..3))
    println("2 !in 1..3 = "+(2 !in 1..3))
    println("'x' in 'a'..'z' = "+('x' in 'a'..'z'))

    // Challenge: Enhancing the Aura
    println("Enhancing the Aura  Challenge")

    var healthPoints=80

    val karma = (Math.pow(Math.random(), (110 - healthPoints) / 100.0) * 20 ).toInt()

    var playerStatus= when(karma){
        in 0..5 -> "red"
        in 6..10 -> "orange"
        in 11..15 -> "purple"
        in 16..20 -> "green"
        else ->"none"
    }
    println("the carma is "+karma)
    println(" player Status is $playerStatus")



    // Challenge: Configurable Status Format
    println("Configurable Status Format  Challenge")


    var hp=100
    var  isBlessed=true
    val auraVisible = isBlessed && healthPoints > 50
    val auraColor = if (auraVisible) "GREEN" else "NONE"
    healthPoints=95
    var name="Madrigal"

    val statusFormatString = " (HP: $hp )(Aura: $auraColor )${if (healthPoints>90)" $name is in excellent condition"

    else ""} ${if (healthPoints<90 && healthPoints >80)" $name has some minor wounds but is healing quite quickl"

    else ""}"


    println(statusFormatString)
}