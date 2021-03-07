package hackerrank.algo.strings

import java.util.*


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val b = scan.nextLine()

    val result = beautifulBinaryString(b)

    println(result)
}

fun beautifulBinaryString(b: String): Any {
    var tmp=b
    var start = 0
    var end = 3
    var count = 0
    while (end < tmp.length+1) {
        val subs = tmp.substring(start, end)
        if (subs == "010") {
            count++
            tmp=tmp.replaceRange(start, end, "011")
        }
        start++
        end++
    }
    return count
}
