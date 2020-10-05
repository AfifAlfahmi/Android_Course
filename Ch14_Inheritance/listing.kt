
fun main() {
    var currentRoom = Room("Foyer")
    var room = Room("Foyer")
    var townSquare = TownSquare()


    print("room is Room ")
    println(room is Room )
    print("room is TownSquare ")
    println(room is TownSquare)
print("townSquare is TownSquare ")
    println(townSquare is TownSquare)
    print("townSquare is Room " )
    println(townSquare is Room)


    var className: String = when(townSquare) {
        is TownSquare -> "TownSquare"
        is Room -> "Room"
        else -> throw IllegalArgumentException()}
    println("class name using when "+className)
    println("room description "+currentRoom.description())
    println(currentRoom.load())

}

open class Room(val name: String) {

    protected open val dangerLevel = 5
    fun description() = "Room: $name\n" +
            "Danger level: $dangerLevel"
    open fun load() = "Nothing much to see here..."
}
class TownSquare : Room("Town Square"){
    override val dangerLevel = super.dangerLevel - 3
    private var bellSound = "GWONG"
    final override fun load() = "The villagers rally and cheer as you enter!\n${ringBell()}"
    private fun ringBell() = "The bell tower announces your arrival. $bellSound"

}