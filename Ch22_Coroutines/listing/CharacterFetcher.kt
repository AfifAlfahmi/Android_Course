package com.example.SAFCSP

import io.ktor.http.ContentDisposition.Companion.File
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.produce
import java.io.File
import java.net.URL

const val ENDPOINT = "http://0.0.0.0:8080/"
const val TEN_SECONDS_IN_MILLISECONDS: Long = 10000
fun main() {
    runBlocking {
        launch {
            println("Started")
            val character = fetchCharacter()
            println(character)
            val characterChannel = pollForCharacters()
            repeat(10) {
                println(characterChannel.receive())
            }
            println("Finished")
        }

    }

}

suspend fun fetchCharacter(): String =withContext(Dispatchers.IO) {
    URL(ENDPOINT).readText()
}

fun CoroutineScope.pollForCharacters(): ReceiveChannel<String> =
        produce {
            while (true) {
                val character = fetchCharacter()
                send(character)
                delay(TEN_SECONDS_IN_MILLISECONDS)
            }
        }


