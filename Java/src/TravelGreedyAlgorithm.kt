/**
 * Created by dastaniqbal on 29/08/2019.
 * ask2iqbal@gmail.com
 * 29/08/2019 12:04
 *
 *
 * https://www.chegg.com/homework-help/questions-and-answers/network-consisting-m-cities-m-1-roads-connecting-given-cities-labeled-distinct-integers-wi-q37619409
 *
 * Question tweeked, only one odd number can visit
 * val arr = arrayOf(0, 9, 0, 2, 6, 8, 0, 8, 3, 0)
 * val index=indexOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
 * final answer of given array is 0-2-3-8
 *
 * Explanation:
 * T[2]=0
 * T[3]=2
 * T[8]=3
 *
 * T[6]=0
 * T[4]=6
 *
 * T[9]=0
 * T[1]=9
 */
fun main(args: Array<String>) {
    val zlist = ArrayList<Int>()
    val arr = arrayOf(0, 9, 0, 2, 6, 8, 0, 8, 3, 0)

    arr.forEachIndexed { index, value ->
        if (index != 0 && value == 0)
            zlist.add(index)
    }
    var max = 0
    zlist.forEach {
        val result = getList(it, arr, false, 1)
        max = Math.max(result, max)
    }
    println(max)
}

fun getList(search: Int, arr: Array<Int>, oddVisited: Boolean, count: Int): Int {
    var oddVisited = oddVisited
    var count = count
    val zlist = ArrayList<Int>()
    arr.forEachIndexed { index, value ->
        if (index != 0 && value == search)
            zlist.add(index)
    }
    if (zlist.size > 0) {
        count++
        val value = zlist[0]
        if (value % 2 != 0) {
            if (oddVisited)
                return count
            else {
                oddVisited = true
                getList(value, arr, oddVisited, count)
            }
        } else {
            getList(value, arr, oddVisited, count)
        }
    }
    return count
}
