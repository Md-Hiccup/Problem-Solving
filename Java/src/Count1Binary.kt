/**
 * Created by dastaniqbal on 29/08/2019.
 * ask2iqbal@gmail.com
 * 29/08/2019 11:04
 */

fun main(args: Array<String>) {
    var c = 32 * 67
    var binary = ""
    while (c > 0) {
        binary += (c % 2).toString()
        c /= 2
    }
    println(binary.reversed())
    val count = binary.reversed().filter {
        it == '1'
    }.count()
    println(count)
}
