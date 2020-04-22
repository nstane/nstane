package ds.interviewQuestions
import kotlin.collections.*


//Complexity is N
fun findMax(list :MutableList<Int>):Int {
    var tmp = 0
    list.forEach {i -> tmp = Math.max(i, tmp)}
    return tmp
}

fun main(args: Array<String>) {
    println(findMax(mutableListOf<Int>(4, 1, 2, 80, 9)))
}
