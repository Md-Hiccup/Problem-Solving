package hackerrank.regex

import java.util.*

object BeautifulNumber {
    @JvmStatic
    fun main(args: Array<String>) {
        val `in` = Scanner(System.`in`)
        val n = `in`.nextLine().toInt()
        val list = ArrayList<String>().apply {
            add("a")
            add("e")
            add("o")
            add("u")
            add("i")
        }

        val result = if (n == 2) list else FormatStringVowel.recursion(3, n, list)

//        result.forEach {
//            println(it)
//        }

        println(result.size)
    }
}