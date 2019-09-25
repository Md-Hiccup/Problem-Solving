package sorting

/**
 * Created by dastaniqbal on 15/10/2018.
 * ask2iqbal@gmail.com
 * 15/10/2018 10:16
 */
class InsertionSort {
    fun sort(array: IntArray) {
        val first = array[0]

        for (index in 1 until array.size) {
            val i=array[index]
            if (i < first) {
                val tmp = first
                array[index - 1] = i
                array[index] = tmp

                println()
                array.forEach {
                    print(" $it")
                }
                println()
            }
        }
    }
}

fun main(args: Array<String>) {
    val array = intArrayOf(31, 41, 59, 26, 41, 58)
    InsertionSort().sort(array)
}