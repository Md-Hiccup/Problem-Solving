package hackerrank.algo.strings

import java.util.*

// Complete the alternatingCharacters function below.
fun alternatingCharacters(s: String): Int {
    var start = 0
    var end = 2
    val len = s.length
    var count = 0;
    while (end != len + 1) {
        val pair = s.substring(start, end)
        if (pair == "AA" || pair == "BB") {
            count++
        }
        start++
        end++
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = alternatingCharacters(s)

        println(result)
    }
}
