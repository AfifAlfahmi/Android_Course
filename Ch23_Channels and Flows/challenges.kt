

//Challenge 1  


fun Flow.filterIfBelowFreezing(unit:String) =
        transform  {

    temperature ->
    if(unit=="Kelvin"){
        temperature <= FREEZING_POINT_KELVIN
            }
    else if(unit =="Celsius"){
        temperature <= FREEZING_POINT_KELVIN-273.15
    }

}


 
// Challenge 2 

var valuesToAdd = listOf(1, 18, 73, 3, 44, 6, 1, 33, 2, 22, 5, 7)

    val greaterThanFive = valuesToAdd.filter { number ->
        (number >= 5)
    }
            .chunked(2).map {
        it ->  it[0] * it[1]
    }
    var total: Int = 0
    for (i in greaterThanFive) {
        total = total + i
    }


   println(total)
