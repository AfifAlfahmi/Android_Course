

fun main() {
    val phrase = "DRAGON'S BREATH: IT'S GOT WHAT ADVENTURERS CRAVE !"
    print("to dragon speak : Madrigal exclaims: ")
    println(phrase.toDragonSpeakExtention())

    println("Welcome, Afif".frameExtension(5))


}

   // Challenge 1
private fun String.toDragonSpeakExtention(): String =
        this.toLowerCase().replace(Regex("[aeiou]")) {

            when (it.value) {
                "a" -> "4"
                "e" -> "3"
                "i" -> "1"
                "o" -> "0"
                "u" -> "|_|"
                else -> it.value
            }
        }


   // Challenge 2
fun String.frameExtension( padding: Int, formatChar: String = "*"): String {
    val greeting = this
    val middle = formatChar
            .padEnd(padding)
            .plus(greeting)
            .plus(formatChar.padStart(padding))
    val end = (0 until middle.length).joinToString("") { formatChar }
    return "$end\n$middle\n$end"

}
    






