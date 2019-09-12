package recursion

/**
 * Created by dastaniqbal on 22/08/2019.
 * ask2iqbal@gmail.com
 * 22/08/2019 10:53
 */


fun main(args: Array<String>) {
    val n = readLine()!!.toInt()

    val start = System.currentTimeMillis()

    printUglyNumber(n)

    println("Total Time Take: ${(System.currentTimeMillis() - start) / (60 * 1000)}")
}

fun printUglyNumber(n: Int) {
    var i = 1
    var result = 0
    var k=0
    do {
        if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i == 1) {
            result = i
            k++
            println("$result ")
        }
        i++
    } while (k < n)

    println(result)
}
