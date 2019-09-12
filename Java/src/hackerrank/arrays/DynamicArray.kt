package hackerrank.arrays

/**
 * Created by dastaniqbal on 09/08/2019.
 * ask2iqbal@gmail.com
 * 09/08/2019 12:54
 */


/*
 * Complete the 'dynamicArray' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY queries
 */

fun dynamicArray(n: Int, queries: Array<Array<Int>>): Array<Int> {
    val seqList = Array(n) { ArrayList<Int>() }
    var lastAnswer = 0

    val arrList = ArrayList<Int>()

    queries.forEach {
        val seq = (it[1] xor lastAnswer) % n
        if (it[0] == 1) {
            seqList[seq].add(it[2])
        } else if (it[0] == 2) {
            lastAnswer = seqList[seq][it[2] % seqList[seq].size]
            arrList.add(lastAnswer)
        }
    }
    return arrList.toTypedArray()
}

fun main(args: Array<String>) {
    val first_multiple_input = readLine()!!.trimEnd().split(" ")

    val n = first_multiple_input[0].toInt()

    val q = first_multiple_input[1].toInt()

    val queries = Array(q) { Array(3, { 0 }) }

    for (i in 0 until q) {
        queries[i] = readLine()!!.trimEnd().split(" ").map { it.toInt() }.toTypedArray()
    }

    val result = dynamicArray(n, queries)

    println(result.joinToString("\n"))
}
