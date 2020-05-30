package ds.interviewQuestions

//Complexity Big O notation is O log n
fun binarySearch(list: MutableList<Int>, element:Int): Int
{

    var low = 0
    var high = list.size -1

    while(low < high) {
        val mid = (high + low)/2

        if(element == list.get(mid)) return mid
        else if(element < list.get(mid)) high = mid-1
        else low = mid+1
    }

    return -1
}

fun main(args : Array<String>) {
    println(binarySearch(mutableListOf(1, 4, 6, 7, 8, 90, 123, 578), 90))
}
