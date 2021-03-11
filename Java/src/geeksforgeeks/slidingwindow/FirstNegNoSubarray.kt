package geeksforgeeks.slidingwindow

import java.util.*


fun main(args: Array<String>) {
    val `in` = Scanner(System.`in`)
    val t = `in`.nextInt()
    for (i in 0 until t) {
        val n = `in`.nextInt()
        val list = ArrayList<Int>()
        for (j in 0 until n) {
            val e = `in`.nextInt()
            list.add(e)
        }
        val k = `in`.nextInt()
        findFirstNegativeDq(list, k)
    }
}

fun findFirstNegative(list: ArrayList<Int>, k: Int) {
    val n = list.size
    var neg = 0
    for (i in 0 until k) {
        val e = list[i]
        if (e < 0) {
            neg = e
            break
        }
    }

    print("$neg ");

    var i = 1
    var j = k
    repeat((k until n).count()) {
        neg = list[i]
        if (neg < 0) {
            print("$neg ")
        } else {
            neg = 0
            (i + 1..j).forEach {
                val e = list[it]
                if (e < 0) {
                    neg = list[it]
                    return@forEach
                }
            }
            print("$neg ")
        }
        if (j < n) {
            i++
            j++
        }
    }

    println("");
}

fun findFirstNegativeDq(arr: ArrayList<Int>, k: Int) {
    val n = arr.size
    var i = 0
    var fneg = 0
    (k - 1 until n).forEach {
        while (i < it && (arr[i] > 0 || i <= it - k)) {
            i++
        }

        fneg = if (arr[i] < 0) {
            arr[i]
        } else {
            0
        }
        print("$fneg ")
    }
    println()
}