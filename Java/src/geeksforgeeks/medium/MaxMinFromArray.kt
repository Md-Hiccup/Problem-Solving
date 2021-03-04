package geeksforgeeks.medium

import java.util.*

fun getMaxMin(arr: Array<String>): Pair<Int, Int> {
    var min = arr[0].toInt()
    var max = arr[0].toInt()
    if (arr.size == 1)
        return Pair(min, max)
    if (arr.size == 2) {
        min = if (arr[0].toInt() < arr[1].toInt()) arr[0].toInt() else arr[1].toInt()
        max = if (arr[0].toInt() > arr[1].toInt()) arr[0].toInt() else arr[1].toInt()
        return Pair(min, max)
    }
    arr.forEach {
        if (it.toInt() < min)
            min = it.toInt()
        if (it.toInt() > max)
            max = it.toInt()
    }

    return Pair(min, max)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim()
    val pair = getMaxMin(q.split(" ").toTypedArray())
    println("${pair.first} ${pair.second}")
}