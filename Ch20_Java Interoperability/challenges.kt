




// challenge 1 
button.setOnClickListener(){

          // Handle click

        }



       // challenge 2
call.onResponse(object : Callback<T>() {
            fun onSuccess(response: T) {
                // TODO: Handle successful response
            }

            fun onFailure(t: Throwable) {
                // TODO: Handle failure
            }
        })

//  

//  the runSimulation fun in kotlin
fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
    val numBuildings = (1..3).random()
    println(greetingFunction(playerName, numBuildings))
}

// challenge 3 
//  the call to runSimulation fun from java with two args String and greetFun

Hero.runSimulation("Afif",greetFun("Afif",29));


//  the greetFun that passed as arg in the above calling 
public static Function2<? super String, ? super Integer, String> greetFun(String player, int numOfBuilds){

        int currentYear = 2020;

        return (s, integer) ->  "player Nmae is "+player +" numOfBuilds ="+numOfBuilds +" currentYear "+currentYear;
    }


//  challenge 4

 public static void runSimulationInJava(String playerName, Function <String, Integer> func) {
        Random rand = new Random();


        int numOfBuilds = rand.nextInt(3);
        System.out.println(greetInJava(playerName,numOfBuilds));
    }
