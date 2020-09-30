import java.util.*
import kotlin.random.Random.Default.nextInt


fun main() {
  println(healthPointCheck(80))
    println(healthPointCustomExcep(19))


}


// Ch6 challenge 1
fun healthPointCheck(healthPoint: Int?) :Boolean{
    require(healthPoint in 0..100)
    { "healthPoint must be in Range from 0 to 100 ,it was $healthPoint" }


    return true
}
// Ch6 challenge 2

class UnskilledHealthPointsException() :
    IllegalStateException("healthPoint must be in Range from 0 to 100  ")


// Ch6 challenge 3


fun healthPointCustomExcep (healthPoint: Int?) :Boolean{
    if(healthPoint in 0..100){
        return true
    }
    else{
        throw UnskilledHealthPointsException()
    }


}






