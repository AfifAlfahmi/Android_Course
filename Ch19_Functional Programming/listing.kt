





fun main() {
    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    val babies = animals
            .map { animal -> "A baby $animal" }
            .map { baby -> "$baby, with the cutest little tail ever!" }
    println(babies)

    val tenDollarWords = listOf("auspicious", "avuncular", "obviate")
    val tenDollarWordLengths = tenDollarWords.map { it.length }
    println(tenDollarWordLengths)
    tenDollarWords.size
    tenDollarWordLengths.size

    listOf(listOf(1, 2, 3), listOf(4, 5, 6)).flatMap { it }


    val itemsOfManyColors = listOf(
            listOf("red apple", "green apple", "blue apple"),
            listOf("red fish", "blue fish"),
            listOf("yellow banana", "teal banana"))
    val redItems = itemsOfManyColors.flatMap { colorList ->
        colorList.filter { color ->
            color.contains("red")
        }
    }
    println(redItems)


    val numbers = listOf(7, 4, 8, 4, 3, 22, 18, 11)
    val primes = numbers.filter { number ->
        (2 until number)
                .map { divisor -> number % divisor }
                .none { remainder -> remainder == 0 }

    }
    println(primes)



    val employees = listOf("Denny", "Claudette", "Peter")
    val shirtSize = listOf("large", "x-large", "medium")
    val employeeShirtSizes = employees.zip(shirtSize).toMap()
    println(employeeShirtSizes["Denny"])




}