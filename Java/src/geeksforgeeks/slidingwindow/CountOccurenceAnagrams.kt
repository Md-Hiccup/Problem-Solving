package geeksforgeeks.slidingwindow

import java.util.*

fun main(args: Array<String>) {
    val `in` = Scanner(System.`in`)
    val str = `in`.nextLine()
    val s = `in`.nextLine()
    countOccurrenceAnagram(str, s)
}

fun countOccurrenceAnagram(str: String, s: String) {
    val k = s.length
    val len = str.length

    var count = 0
    var substr = str.substring(0, k)
    if (exist(substr, s)) {
        count++
    }

    var start = 1
    var end = k
    (k + 1..len).forEach {
        substr = str.substring(start, it)
        if (exist(substr, s)) {
            count++
        }
        if (end < len) {
            start++
            end++
        }
    }

    println(count)
}

fun exist(sub: String, str: String): Boolean {
    val list = str.toList() as ArrayList<Char>
    sub.forEach {
        if (list.contains(it)) {
            list.remove(it)
        }
    }
    return list.isEmpty()
}