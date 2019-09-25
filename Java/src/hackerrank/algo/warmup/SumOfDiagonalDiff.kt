package hackerrank.algo.warmup

/**
 * Created by dastaniqbal on 15/07/2019.
 * ask2iqbal@gmail.com
 * 15/07/2019 11:13
 */

/*
 * Complete the 'diagonalDifference' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
 */

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    val n = arr.size
    var lrd = 0
    var rld = 0

    for (row in 0 until n) {
        lrd += arr[row][row]
    }

    for ((r, col) in (n - 1 downTo 0).withIndex()) {
        rld += arr[r][col]
    }

    return Math.abs(lrd - rld)
}

fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()
    val arr = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

    for (i in 0 until n) {
        arr[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = diagonalDifference(arr)

    println(result)
}
