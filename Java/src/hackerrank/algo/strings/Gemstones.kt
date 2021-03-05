package hackerrank.algo.strings

import java.util.*

// Complete the gemstones function below.
fun gemstones(arr: Array<String>): Int {
    val list = ArrayList<Char>()
    var rock = 0
    if (arr.size == 1) return 0
    var length = 0;
    val first = arr.filter {
        if (it.length > length) {
            length = it.length
            true
        } else {
            false
        }
    }.toList()[0]

    first.forEach {
        if (!list.contains(it)) {
            list.add(it)
            if (charExist(arr, first, it)) rock++
        }
    }
    return rock
}

fun charExist(arr: Array<String>, str: String, ch: Char): Boolean {
    var exist = true
    run loop@{
        arr.filter { str != it }
                .forEach {
                    if (!it.trim().contains(ch)) {
                        exist = false
                        return@loop
                    }
                }
    }
    return exist
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = Array<String>(n, { "" })
    for (i in 0 until n) {
        val arrItem = scan.nextLine()
        arr[i] = arrItem
    }

    val result = gemstones(arr)

    println(result)
}