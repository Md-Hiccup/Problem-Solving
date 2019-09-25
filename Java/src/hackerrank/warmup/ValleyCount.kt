package hackerrank.warmup

import java.util.*

/**
 * Created by dastaniqbal on 05/07/2019.
 * ask2iqbal@gmail.com
 * 05/07/2019 12:03
 */

// Complete the hackerrank.warmup.countingValleys function below.
fun countingValleys(n: Int, s: String): Int {
    var valley = 0
    var sealevel = s.startsWith("D")
    var step = 0
    s.forEach { char ->
        if (char == 'D') {
            step += 1
        } else if (char == 'U') {
            step -= 1
            sealevel = step == 0
            if (step == 0 && sealevel)
                valley += 1
        }
    }
    return valley
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val s = scan.nextLine()

    val result = countingValleys(n, s)

    println(result)
}