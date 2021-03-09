package hackerrank.algo.strings

import java.util.*
import kotlin.math.ceil
import kotlin.math.roundToInt

// Complete the theLoveLetterMystery function below.
fun theLoveLetterMystery(s: String): Int {
    val mid = ceil(s.length / 2f).roundToInt()
    var count = 0
    s.drop(mid).forEachIndexed { index, c ->
        var bChar = c
        var fChar = s[mid - (if (s.length % 2 == 0) 0 else 1) - index - 1]
        if (bChar >= fChar) {
            while (bChar != fChar) {
                bChar -= 1
                count++
            }
        } else {
            while (bChar != fChar) {
                fChar -= 1
                count++
            }
        }
    }
    return count
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = theLoveLetterMystery(s)

        println(result)
    }
}
