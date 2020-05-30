package `datetime`

import java.time.LocalDate

fun main() {
    val D_OF_WEEKS = intArrayOf(1, 2, 4, 8, 16, 32, 64)
    for(i in 1..7) {
        val date = LocalDate.now().plusDays(i.toLong())
        println(date.toString()+" "+ date.dayOfWeek.toString())
        var dayOfWeek = date.dayOfWeek.value;
        if(dayOfWeek == 7) dayOfWeek = 0
        println("   "+dayOfWeek+" "+ D_OF_WEEKS[dayOfWeek])
    }
}
