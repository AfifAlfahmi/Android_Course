import kotlin.system.exitProcess
fun main() {

    Game.play()
}


object Game {
    private var currentRoom: Room = TownSquare()
    var monster: Monster = Goblin("Goblin")
    var criminal: Monster = Goblin("Criminal")




    var beIntheGame =true
    var newPoist :Coordinate? = null
    private var worldMap = listOf(listOf(currentRoom, Room("Tavern"),
            Room("Back Room")),listOf(Room("Long Corridor"), Room("Generic Room")))
    private fun map()  {
        return try {

            val direction = Direction.valueOf("north".toUpperCase())
            val newPosition = direction.updateCoordinate(Coordinate(1, 2))
            newPoist = newPosition

            val newRoom = worldMap[newPosition.y][newPosition.x]

            println("OK, you move $newPoist $direction to the ${newRoom.name}.\n${newRoom.load()}")

        }
        catch (e: Exception) {
            println( "Invalid direction: ")
        }

    }
    var player = Player("Afif",44,true,false)

    fun ringBell(){
        println("The bell is ringing")
    }

    private fun fight(): String {
        val currentMonster = currentRoom.monster
        var fightResultMessage: String =""
        currentRoom.listOfMonster.add(monster)
        currentRoom.listOfMonster.add(criminal)

        if(currentRoom.listOfMonster.size ==0){

            println( "There's nothing here to fight.")
            fightResultMessage="There's nothing here to fight."
        }
        else if(currentRoom.listOfMonster.size ==1){
            println("here's one Monster to fight it .")
            while (player.healthPoints > 0 && currentRoom.listOfMonster[0].healthPoints > 0) {
                slay(currentRoom.listOfMonster[0])
                Thread.sleep(1000)
            }
            println("Combat complete.")

        }
        else if (currentRoom.listOfMonster.size ==2){
            println("here's two Monster and you can fight one .")
            println("> Select one Monster type 1 to fight "+currentRoom.listOfMonster[0].name)
            print(">  type 2 to fight "+currentRoom.listOfMonster[1].name)
            var selectedMonster = readLine()
            println( selectedMonster )
              if(selectedMonster == "1" ){
                  while (player.healthPoints > 0 && currentRoom.listOfMonster[0].healthPoints > 0) {
                      slay(currentRoom.listOfMonster[0])
                      Thread.sleep(1000)
                  }
                  println("Combat complete.")

              }
            else if(selectedMonster == "2"){
                  while (player.healthPoints > 0 && currentRoom.listOfMonster[1].healthPoints > 0) {
                      slay(currentRoom.listOfMonster[1])
                      Thread.sleep(1000)
                  }
                  println("Combat complete.")

              }
            else{
                  println("here's a lot of  Monsters and you can fight one .")
                  while (player.healthPoints > 0 && currentRoom.listOfMonster[0].healthPoints > 0) {
                      slay(currentRoom.listOfMonster[0])
                      Thread.sleep(1000)
                  }
                  println("Combat complete.")
              }



        }

















        return fightResultMessage
    }


    private fun slay(monster: Monster) {
        println("${monster.name} did ${monster.attack(player)} damage!")
        println("${player._name} did ${player.attack(monster)} damage!")
        if (player.healthPoints <= 0) {
            println(">>>> You have been defeated! Thanks for playing. <<<<")
            exitProcess(0)
        }
        if (monster.healthPoints <= 0) {
            println(">>>> ${monster.name} has been defeated! <<<<")
            currentRoom.monster = null
        }
    }

    private class GameInput(arg: String?) {
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1) { "" }
        private fun commandNotFound() = "I'm not quite sure what you're trying to do!"


        fun processCommand(): Any = when (command.toLowerCase()) {

            "quit","exit"->  {beIntheGame=false}
            "map" -> {map()
                println(" $newPoist")}
            "fight" -> fight()

            "ring" -> ringBell()
            else -> commandNotFound()
        }
    }
    init {
        println("Welcome, adventurer.")

    }
    fun play() {
        var i=0
        while (beIntheGame) {
            // Play NyetHack
            println(currentRoom.description())
            println(currentRoom.load())

            print("> Enter your command: ")
            println( GameInput(readLine()).processCommand() )
            i++
        }
        println( "the game terminated" )

    }




}




open class Room(val name: String) {
    protected open val dangerLevel = 5
    open fun load() = "Nothing much to see here..."
    var monster: Monster? = Goblin()
    var listOfMonster = mutableListOf<Monster>()

    fun description() = "Room: $name\n" +"Danger level: $dangerLevel\n" +"Creature: ${monster?.description ?: "none."}"
}

class TownSquare : Room("Foyer"){
    override  fun load() = "Nothing much to see here..."
    override fun toString(): String =
            if (this is TownSquare) {
                "instance of TownSquare"
            }
            else  if (this is Room){
                "instance of Room"
            }
            else {
                "instance of Any"

            }

}


data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0

    operator fun plus(other: Coordinate) = Coordinate(x + other.x, y + other.y)
}

enum class Direction(private val coordinate: Coordinate) {
    NORTH(Coordinate(0, -1)),
    EAST(Coordinate(1, 0)),
    SOUTH(Coordinate(0, 1)),
    WEST(Coordinate(-1, 0));
    fun updateCoordinate(playerCoordinate: Coordinate) =
            Coordinate(playerCoordinate.x + coordinate.x,playerCoordinate.y + coordinate.y)

}

