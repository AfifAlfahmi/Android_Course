








fun main() {

    doubleToFloat(3.2)
  var room = Room("Foyer")
   
    var townSquare = TownSquare()
    println("is the two instances equal "+isRoomEqual(room,townSquare))
    println("check argument type "+checkType(room))
println(townSquare.toString())

}

fun doubleToFloat(any: Any) {
    val isSourceOfBlessings: Float =if (any is Double) {
       
 println("$any is  converted  to Float ")
 any.toFloat()
    }
    else {
       println(" invalid value, the value  must be of Double to convert it  to Float ")
       (0.0).toFloat()
    }
  println("  the converted value to Float is "+isSourceOfBlessings)

}


open class Room(val name: String) {
   
    open fun load() = "Nothing much to see here..."
   
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

fun isRoomEqual(room1:Room, room2:Room):Boolean {
    if(room1 is Room &&  room2 is Room ){
         return room1.name === room2.name;
    }
    else{
        return false
    }
 
}



fun checkType(any:Any):String{ 
var argType: String = when(any) {
    is TownSquare -> "3"
    is Room -> "2"
    is Any -> "1"
    else -> 
    throw IllegalArgumentException()
}
return argType
}

    



