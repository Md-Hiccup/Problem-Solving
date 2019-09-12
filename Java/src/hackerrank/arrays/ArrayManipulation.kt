package hackerrank.arrays

/**
 * Created by dastaniqbal on 09/08/2019.
 * ask2iqbal@gmail.com
 * 09/08/2019 5:26
 */
import java.util.*
import kotlin.collections.HashMap

// Complete the arrayManipulation function below.

data class ArraySum(var start: Long, var end: Long, var sum: Long)

fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    val array = HashMap<Long, Long>()
    var max = 0L
    queries.forEach {
        val a = it[0] - 1
        val b = it[1] - 1
        val k = it[2]
        val index = a + b
//        array[index.toLong()] = k.toLong()
//        max = Math.max(max, array[index])
    }
    return max
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nm = scan.nextLine().split(" ")

    val n = nm[0].trim().toInt()

    val m = nm[1].trim().toInt()

    val queries = Array<Array<Int>>(m, { Array<Int>(3, { 0 }) })

    for (i in 0 until m) {
        queries[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val cur = System.currentTimeMillis()
    val result = arrayManipulation(n, queries)

    println(result)
    println("Total time take ${(System.currentTimeMillis() - cur)}")
}
