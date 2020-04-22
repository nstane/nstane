package features

fun main(a: Array<String>) {
    //compile time mutable and immutable check
    //immutable collection
    val list = listOfNotNull(null)
    val set = setOf("j","j","o","k","e","r")
    val map = mapOf(Pair("hello","narender"), Pair("isNarender", true))

    val mutableList = mutableListOf("one")
    mutableList.add("two")

    println(list )
    println(set)
    println(map)
    println(mutableList)

    //list.forEach { i -> println(i) }
    //map.forEach { t, u -> println(t) }

    list.takeIf { it.isNotEmpty() }?.let { println(it) }

    list.spliterator().also { emptyList<String>() }
}