package google.kickstart.`2021`

import java.util.*
import kotlin.math.ceil
import kotlin.math.floor


fun main(args: Array<String>) {
    val `in` = Scanner(System.`in`)
    val test = `in`.nextLine()

    repeat((0 until test.toInt()).count()) {

        val line = `in`.nextLine().split(" ")
        val N = line[0].toInt()
        val K = line[1].toInt()
        val str = `in`.nextLine()

        println("Case #${it+1}: ${calculateGoodNessString(N, K, str)}")
    }
}

fun calculateGoodNessString(N: Int, K: Int, str: String): Int {
    var gs = 0
    (1..floor(N / 2f).toInt()).forEach { it ->
        if (str[it - 1] != str[str.length - 1 - (it - 1)]) gs++
    }

    return when {
        gs == K -> 0
        gs > K -> gs - K
        else -> K - gs
    }
}
