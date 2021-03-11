package geeksforgeeks.slidingwindow

import java.util.*
import kotlin.math.max


fun main(args: Array<String>) {
    val ip = Scanner(System.`in`);
    val n = ip.nextLine().toInt()
    val k = ip.nextLine().toInt()
    val arr = Array(n) { 0 }
    (0 until n).forEach {
        val e = ip.nextInt()
        arr[it] = e
    }

    var sum = 0;
    (0 until k).forEach {
        sum += arr[it]
    }

    var maxSum = sum
    var i = 1
    var j = k
    (k until n).forEach {
        sum = sum - arr[i - 1] + arr[j]
        maxSum = max(maxSum, sum)
        if (j < n) {
            i++
            j++
        }
    }

    println(maxSum)
}