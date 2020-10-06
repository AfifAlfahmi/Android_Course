


// Chapter 17 challenge 1

inline fun <reified T> greetingMessage(greet:  T): String {

    return if (greet is List<*>) {
        greet.first().toString()
    }
    else if(greet is CharArray){
        var greetInStr=""
        for (i in greet){
            greetInStr = greetInStr + i

        }
        greetInStr

    }
    else if(greet is String){

        greet


    }
    else {
        "Invalid Greeting"
    }
}

// Chapter 17 challenge 2

inline fun  <reified T> printIsSourceOfBlessings(generic: T) {
    val isSourceOfBlessings: Boolean = if (generic is Player) {
        generic.isBlessed
    } else {
        (generic as Room).name == "Fount of Blessings"
    }
    println("$generic is a source of blessings: $isSourceOfBlessings")
}

fun main() {
    val greetingList = listOf("Nice", "Welcome", "Hello")
    val greetingArrOfChar= charArrayOf('H','e','l','l','o')
   val greetingString ="Welcome Afif"
    var player = Player("Afif",44,true,false)

    println(greetingMessage(greetingArrOfChar))
    println(printIsSourceOfBlessings(player))


}