package com.example.safcsp

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.html.*
import kotlinx.html.*
import freemarker.cache.*
import io.ktor.freemarker.*
import io.ktor.http.ContentDisposition.Companion.File

private const val DICE_SIDES_COUNT = 6
private const val DEX_DICE_COUNT = 4
private const val WIS_DICE_COUNT = 3
private const val STR_DICE_COUNT = 2
private fun Int.rollDice(): Int =(1..this).map {
    (1..DICE_SIDES_COUNT).random() }.sum()

class Character {
    private val name: String = java.io.File("data/names.txt").readLines().random()
    private val fantasyRace: String = listOf("Dwarf", "Elf", "Human", "Halfling").random()
    private val dex: Int = DEX_DICE_COUNT.rollDice()
    private val wis: Int = WIS_DICE_COUNT.rollDice()
    private val str: Int = STR_DICE_COUNT.rollDice()
    override fun toString(): String {return "$name, $fantasyRace  $dex, $wis, $str"}
}
fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)
@Suppress("unused") // Referenced in application.conf
 @kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {

    routing {
        get("/") {
            call.respondText(
                //"Hello world!"
                        Character().toString(),contentType = ContentType.Text.Plain)
        }
        get("/characters") {
//            call.respondText(
//                "Characters!",contentType = ContentType.Text.Plain)

            call.respondHtml {
                body {h1 { +"Characters" }
                   // p { +"Characters go here" }
                    ul {for (n in 1..10) {
                        li { +"Character $n: ${Character()}" }
                    }
                    }

                }}
        }

    }}