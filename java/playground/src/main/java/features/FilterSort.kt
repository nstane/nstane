package features

fun main(array: Array<String>) {

    val ints = listOf(1,2,3,4,5,6,7,8)

    val countGraterThan5Predicate = {
        v:Int -> v > 5
    }
    val allGraterThan7 = ints.all { it > 7 }

    val anyGraterThan7 = ints.any { it > 7 }

    val countGraterThan5 = ints.count(countGraterThan5Predicate)

    val findGraterThan7 = ints.find { it > 7 }

    println("allGraterThan7 $allGraterThan7")

    println("anyGraterThan7 $anyGraterThan7")

    println("countGraterThan5 $countGraterThan5")

    println("findGraterThan7 $findGraterThan7")

    // filter and map
    val squareOfGraterThan5 = ints.filter(countGraterThan5Predicate).map {it * it }

    println("squareOfGraterThan5 $squareOfGraterThan5")

    //Use sequesnce for large collection benefits as lazy evaluated sequences = streams in java 8
    for(i in ints.asSequence().filter(countGraterThan5Predicate).map(countGraterThan5Predicate)){
        println(i)
    }
}