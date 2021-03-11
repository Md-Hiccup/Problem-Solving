package geeksforgeeks.hard

import java.util.*

fun findNth(n: Long): Long {
    return if (n < 9) n
    else {
        return n + (n / 9)
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLong()
    println(findNth(q))
}

//1 2 3 4 5 6 7 8 10 11 12 13 14 15 16 17 18 20 21