package hackerrank.arrays

/**
 * Created by dastaniqbal on 10/07/2019.
 * ask2iqbal@gmail.com
 * 10/07/2019 1:55
 */
import java.util.*

// Complete the minimumBribes function below.
fun minimumBribes(q: Array<Int>): Unit {
    var value = 0
    var swapCount = 0
    var bribeCount = 0
    for (i in q.size - 2 downTo 0) {
        value = q[i]
        if (swapCount >= 3) {
            break
        }
        swapCount = 0
        for (j in i until q.size) {
            if (value > q[j]) {
                swapCount++
                bribeCount++
            }
        }
    }
    if (swapCount >= 3) {
        println("Too chaotic")
    } else {
        println(bribeCount)
    }

    val a=Array<Int>(2){0};
    a[0]
}

fun minimumBribes1(q: Array<Int>): Unit {
    var bribeIndex = 0
    var bribeCount = 0
    var swapCount = 0
    for (i in q.size - 1 downTo 0) {
        if (i - 1 >= 0 && q[i] < q[i - 1]) {
            bribeIndex = i - 1
            if (swapCount == 3) {
                break
            }
            swapCount = 0
            for (j in bribeIndex until q.size - 1) {
                if (j + 1 < q.size && q[j] > q[j + 1]) {
                    q[j] = q[j + 1].also { q[j + 1] = q[j] }
                    bribeCount++
                    swapCount++
                    if (swapCount == 3) {
                        break
                    }
                }
            }
        }
    }
    if (swapCount >= 3) {
        println("Too chaotic")
    } else {
        println(bribeCount)
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val n = scan.nextLine().trim().toInt()

        val q = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

        minimumBribes(q)
    }
}
