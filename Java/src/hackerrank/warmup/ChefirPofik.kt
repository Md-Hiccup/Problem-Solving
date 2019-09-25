package hackerrank.warmup

import javax.swing.text.html.HTML.Attribute.N



/**
 * Created by dastaniqbal on 19/08/2019.
 * ask2iqbal@gmail.com
 * 19/08/2019 4:53
 */

fun main(args: Array<String>) {
    val input = readLine()!!.toInt()
    repeat(input) {
        val str = readLine()!!.toString().split(" ")
        val n = str[0].toInt()
        val m = str[1].toInt()
        val x = str[2].toInt()
        val y = str[3].toInt()

        printSolution(n, m, x, y)
    }
}


fun printSolution(N: Int, M: Int, x: Int, y: Int) {
    var n = N - 1
    var m = M - 1
    val result = if (n % x == 0 && m % y == 0)
        "Chefirnemo"
    else {
        if (n > 0 && m > 0) {
            n--
            m--
        }
        if (n % x == 0 && m % y == 0)
            "Chefirnemo"
        else
            "Pofik"
    }
    println(result)
}
