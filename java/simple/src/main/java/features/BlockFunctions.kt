package features

fun main() {
    val str = "Hello Narender"
    println(str.toUpperCase().plus(" Bye"))
    str.associateWith { it.isUpperCase() }
    StringBuilder().also { it.append(903).append(34) }.toString()
    println(1 and 1)
    println(1 or 2)

    for (e in 1..45){
        println(e)
    }

    for (e in 1 until 45){
        println(e)
    }

    if(1 !in 1..2)
        println("-1 not in range 1..2")
}