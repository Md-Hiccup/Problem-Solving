package recursion

/**
 * Created by dastaniqbal on 21/08/2019.
 * ask2iqbal@gmail.com
 * 21/08/2019 10:29
 */

/**
 * Convert to DP
 */
fun printString(strLen: Int, str: String, arr: Array<String>) {
    arr.forEachIndexed { _, value ->
        val app = str + value
        if (app.length == strLen) {
            println(app)
        } else {
            printString(strLen, app, arr)
        }
    }
}

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.toString().split(" ").toTypedArray()

    val start = System.currentTimeMillis()

    printString(n, "", arr)

    val total = System.currentTimeMillis() - start
    println("Total Time Take: $total")
}