package hackerrank.warmup

import java.util.*

/**
 * Created by dastaniqbal on 09/07/2019.
 * ask2iqbal@gmail.com
 * 09/07/2019 9:56
 */
/**
 *
 */


fun repeatedString(s: String, n: Long): Long {
    val strLen = s.length
    var countA = 0
    s.forEach {
        if (it == 'a') {
            countA++
        }
    }

    val times = n / strLen
    val leftA = n % strLen

    var totA = times * countA
    for (i in 0 until leftA.toInt()) {
        if (s[i] == 'a') {
            totA++
        }
    }

    return totA
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}
