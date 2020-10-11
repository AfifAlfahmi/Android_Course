
// Challenge 1 Minimum Strength

suspend fun fetchCharacter(): String =withContext(Dispatchers.IO) {
    var data :String =URL(ENDPOINT).readText()
    var itemslist = data.split(",").toList()
    var str =itemslist[3].trim().toInt()


    if(str < 10){
     "strength value less than 10 "

    }
    else{
        URL(ENDPOINT).readText()

    }

}

// Challenge 2  initialize the Player’s hometown 


fun main() {    
    GlobalScope.launch {
     
        val hometown =  selectHometown()
        
          }
}


private suspend fun selectHometown():String =withContext(Dispatchers.IO)
    {

        File("C:/Users/afef2/IdeaProjects/NyetHack/src/data/towns.txt")

                .readText()
                .substring(ranNum, ranNum + 5)
    }





