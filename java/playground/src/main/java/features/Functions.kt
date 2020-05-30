package features
fun main()
{
    // Extensions functions replacement of static util classes
    println("Narender       is    SDE in  Expedia.      ".replaceMultipleSpaces())

    // Infix function
    val two = 1 plus 1
    println(two)

    // function with default param and named param
    defaultParam()
    defaultParam(name = "john")

    println("!#@!#%^$^&%&*^((*&()*)()(_(_)JHGHJBHJB_:<>?~~".replace("/[a-zA-Z0-9\\' ]/g", ""))
}


//Extension functions
fun String.replaceMultipleSpaces() = Regex("\\s+").replace(this, " ")

fun defaultParam(name: String = "Narender") = println("hello ${name}")

//infix functions(use for operator overload)  as extension
infix fun Int.plus(other: Int): Int {
    return this + other
}