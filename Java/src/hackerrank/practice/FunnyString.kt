package hackerrank.practice

import java.util.*
import kotlin.math.abs

// Complete the funnyString function below.
fun funnyString(s: String): String {
    val revS = s.reversed()
    var isFunny = true
    s.forEachIndexed { index, i ->
        if (index < s.length - 1) {
            val a = abs(s[index] - s[index + 1])
            val b = abs(revS[index] - revS[index + 1])
            if (a != b) isFunny = false
        }
    }
    println(if (isFunny) "Funny" else "Not Funny")
    return ""
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = funnyString(s)

        println(result)
    }
}
