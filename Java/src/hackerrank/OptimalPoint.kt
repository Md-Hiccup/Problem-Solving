package hackerrank

/**
 * Created by dastaniqbal on 09/07/2019.
 * ask2iqbal@gmail.com
 * 09/07/2019 11:49
 */


/*
 * Complete the 'hackerrank.optimalPoint' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY magic
 *  2. INTEGER_ARRAY dist
 */

fun optimalPoint(magic: Array<Int>, dist: Array<Int>): Int {
    var start = 0
    var end = 1
    var magicPoint = magic[start] - dist[start]

    while (end != start || magicPoint < 0) {

        while (magicPoint < 0 && start != end) {
            magicPoint -= magic[start] - dist[start]
            start = (start + 1) % magic.size

            if (start == 0)
                return -1
        }
        magicPoint += magic[end] - dist[end]

        end = (end + 1) % magic.size
    }
    return start
}

fun main(args: Array<String>) {
    val magicCount = readLine()!!.trim().toInt()

    val magic = Array<Int>(magicCount, { 0 })
    for (i in 0 until magicCount) {
        val magicItem = readLine()!!.trim().toInt()
        magic[i] = magicItem
    }

    val distCount = readLine()!!.trim().toInt()

    val dist = Array<Int>(distCount, { 0 })
    for (i in 0 until distCount) {
        val distItem = readLine()!!.trim().toInt()
        dist[i] = distItem
    }

    val result = optimalPoint(magic, dist)

    println(result)
}
