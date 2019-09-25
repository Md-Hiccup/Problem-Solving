package hackerrank.arrays

/**
 * Created by dastaniqbal on 10/07/2019.
 * ask2iqbal@gmail.com
 * 10/07/2019 11:09
 */
import java.util.*

// Complete the rotLeft function below.
fun rotLeft1(a: Array<Int>, d: Int): Array<Int> {
    for (i in 1..d) {
        val tmp = a[0]
        for (j in 0 until a.size - 1) {
            a[j] = a[j + 1]
        }
        a[(a.size - 1)] = tmp
    }

    return a
}

fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    val result = Array(a.size) { 0 }
    var index = d
    for (i in 0 until a.size) {
        val value = a.getOrNull(index)
        if (value != null) {
            result[i] = value
            index++
            if (index >= a.size) {
                index=0
            }
        }
    }

    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}
