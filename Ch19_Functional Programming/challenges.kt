


fun main() {

    // Challenge 1  Reversing the Values in a Map
    val gradesByStudent = mapOf("Josh" to 4.0, "Alex" to 2.0, "Jane" to 3.0)
    println(gradesByStudent)
    val reverseUsingAssociate = gradesByStudent.entries.associate { (key, value) -> value to key }

    val reverseUsingMap: Map<Double,String > = gradesByStudent.map { (key, value) -> value to key }.toMap()
    println("reversed Map")
    println(reverseUsingMap)



    // Challenge 2 uniquePatrons using generateSequence

    val patronList: List<String> = listOf("Eli", "Mordoc", "Sophie","Afif")
    val lastName = listOf("Ironfoot", "Fernsworth", "Baggins","Alfahmi")


    val uniquePatrons: Set<String> = generateSequence {

        val first = patronList.random()
        val last = lastName.random()
        "$first $last" }.distinct()
            .take(9).toSet()


    println("9 unique Patrons "+uniquePatrons)

    // Challenge 3  Sliding Window

    var valuesToAdd = listOf(1, 18, 73, 3, 44, 6, 1, 33, 2, 22, 5, 7)
    val greaterThanFive = valuesToAdd.filter { number ->
        (  number >= 5)

    }
    println("greater Than or equal fife "+greaterThanFive)  // 18 ,73 , 44 ,6 ,33 ,22 , 5, 7
    val firstPart =greaterThanFive.slice(0..1 )
    val secondPart =greaterThanFive.slice(2..3 )
    val thirdPart =greaterThanFive.slice(4..5 )
    val forthPart =greaterThanFive.slice(6..7 )
    var combinedList= listOf(listOf(firstPart, secondPart,thirdPart,forthPart)).flatMap { it }

    var sumCombined = combinedList.map {
        it -> it[0]*it[1]

    }
    var total:Int= 0
    for(i in sumCombined){
        total=total+i
    }

    println("Grouped in pairs "+combinedList)
    println("Multiply the two numbers "+sumCombined)
    println("Total "+total)



}