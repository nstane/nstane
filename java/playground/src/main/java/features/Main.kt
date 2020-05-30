package features

import okhttp3.ResponseBody
import restclient.RetrofitClient
import services.GitService

/**
 * Benefits of kotlin
 * 1. Type safety
 * 2. null safety {if and when}
 * 3. Loops
 * 4. Default params and name parameter(parama order not matter)
 * 5. extension function //add them to existing class and replace util classes (No more any static util classes)
 *
 */
fun main()
{
    // Loop
    printRange()
    printReverse()
    printWithStep()

    //exception handle
    val divideByZero = try {
        12/0
    } catch (e: Exception){
        -1
    }
    println(divideByZero)

    (2..90)

   println(3+2.3)
}

fun printRange() {
    val range = 1..10
    for (i in range) {
        println(i)
    }
}

fun printReverse() {
    for (i in 10 downTo 1) {
        println(i)
    }
}

fun printWithStep() {
    val range = 1..10
    for (i in range step 2) {
        println(i)
    }
}






