package features

import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)

    val N = scan.nextLine().trim().toInt()
    if(isOdd(N) || (!isOdd(N) && inRange(N, 6, 20))){
        println("Weird")
    }

    if(!isOdd(N) && (N > 20 || inRange(N, 2, 5))) {
            println("Not Weird")
    }
}


fun isOdd(n:Int): Boolean{
    return n%2 > 1
}

fun inRange(n:Int,x:Int, y:Int): Boolean {
    return x < n && n < y
}
