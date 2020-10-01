import java.util.*
import kotlin.random.Random.Default.nextInt



fun main() {


//Ch9 challenge 1
    println("enter a string to capitalize it with let function")
    var beverageLet = readLine().let {
        it?.capitalize()
            ?: "I can't do that without crashing - beverage was null!"
    }

    println(beverageLet)

    //Ch9 challenge 2

    println("enter a string to capitalize it with Takeif function")

    var beverageTake = readLine().
    takeIf {! it.isNullOrEmpty()  }
        ?.capitalize()
    println(beverageTake)
}



