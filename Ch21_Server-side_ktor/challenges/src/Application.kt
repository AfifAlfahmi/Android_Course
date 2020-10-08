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
import io.ktor.http.content.resources
import io.ktor.http.content.static

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(FreeMarker) {
        templateLoader = ClassTemplateLoader(this::class.java.classLoader, "templates")
    }

    routing {

        static("/static") {
            resources("static")
        }
        get("/") {
            call.respondText("HELLO WORLD!", contentType = ContentType.Text.Plain)
        }
var listOfDrinks = listOf<String>("coffe","tea","water","juice")
        get("/drinks") {
            call.respondHtml {
                body {
                    h1 { +"Afif website using ktor" }
                    ul {
                        for (n in 0..3) {
                            li { +listOfDrinks[n] }
                        }
                    }
                }
            }
        }
        get("/map") {
            call.respond(FreeMarkerContent("index.ftl", mapOf("data" to IndexData(listOf(1, 2, 3))), ""))
        }

        get("/user") {
            call.respondRedirect("/login", permanent = false)

        }

        get("/htmldsl") {
            val data = IndexData(listOf(1, 2, 3))
            call.respondHtml {
                head {
                    link(rel = "stylesheet", href = "/static/styles.css")
                }
                body {
                    ul {
                        for (item in data.items) {
                            li { +"$item" }
                        }
                    }
                }
            }
        }

        route("/login") {
            get {
                call.respond(FreeMarkerContent("login.ftl", null))
            }
            post {
                val post = call.receiveParameters()
                if (post["username"] != null && post["username"] == post["password"]) {


                    call.respondText("OK")
                } else {
                    call.respond(FreeMarkerContent("login.ftl", mapOf("error" to "Invalid login")))
                }
            }
        }

    }
}

data class IndexData(val items: List<Int>)

