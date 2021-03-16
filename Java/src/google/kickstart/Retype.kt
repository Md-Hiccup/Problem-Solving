package google.kickstart

import java.util.*

fun main(args: Array<String>) {
    val `in` = Scanner(System.`in`)
    val test = `in`.nextLine()

    repeat((0 until test.toInt()).count()) {

        val line = `in`.nextLine().split(" ")
        val n = line[0].toBigInteger()
        val k = line[1].toBigInteger()
        val s = line[2].toBigInteger()

        if (s > k) {
            println("Case ${it + 1}: " + n)
        } else {
            val base = k.minus(1.toBigInteger())
            val restart = base + n + 1.toBigInteger()
            val backword = base + (k - s) + (n - s) + 1.toBigInteger()

            if (restart < backword) {
                println("Case ${it + 1}: " + restart)
            } else {
                println("Case ${it + 1}: " + backword)
            }
        }
    }
}