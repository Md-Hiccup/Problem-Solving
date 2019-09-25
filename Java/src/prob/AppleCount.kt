package prob

/**
 * Created by dastaniqbal on 01/07/2019.
 * ask2iqbal@gmail.com
 * 01/07/2019 5:53
 */
class AppleCount {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val totalApples = readLine()
            val giaHasExtraApples = readLine()

            val apples = totalApples!!.toInt() - giaHasExtraApples!!.toInt()

            val maddie = apples / 2
            val gia = maddie + giaHasExtraApples.toInt()

            println(gia)
            println(maddie)

        }
    }
}