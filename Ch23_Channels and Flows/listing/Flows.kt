package com.example.SAFCSP

import jdk.jfr.internal.OldObjectSample.emit
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Flow


fun main() {
//    var primeFlow: Flow<Int> = oneThousandPrimes.asFlow()
    runBlocking {
//        primeFlow.collect { primeNumber ->

            //println(primeNumber)
   // }
        primesFlow.filter {
            it.isPrime()
        }.take(1000)
                .collect {
                    println(it) }
    }
}

const val FREEZING_POINT_KELVIN = 273.15


fun Flow.filterIfBelowFreezing(unit:String) =
        transform { 
            temperature ->if (temperature <= FREEZING_POINT_KELVIN) {emit(temperature)
        }
        }






val primesFlow= flow {
    var number = 3
    while (true) {
        emit(number)
        number++
    }
}


val oneThousandPrimes = generateSequence(3) { value -> value + 1 }
        .filter { it.isPrime() }
        .take(1000)
// Extension to Int that determines whether a number is prime
fun Int.isPrime(): Boolean {
    (2 until this)
            .map { divisor ->if (this % divisor == 0) {
                return false
            }
    }

return true
}