package hackerrank.regex

import java.util.*

object FormatStringVowel {

    fun recursion(i: Int, n: Int, list: ArrayList<String>): ArrayList<String> {
        val result = ArrayList<String>();
        list.forEach {
            when {
                it.endsWith("a") -> {
                    result.add(it + "e")
                    result.add(it + "o")
                }
                it.endsWith("e") -> {
                    result.add(it + "i")
                }
                it.endsWith("o") -> {
                    result.add(it + "i")
                }
                it.endsWith("u") -> {
                    result.add(it + "i")
                }
                it.endsWith("i") -> {
                    result.add(it + "a")
                    result.add(it + "e")
                    result.add(it + "o")
                    result.add(it + "u")
                }
            }
        }
        if (i == n) {
            return result;
        }
        result.sort()
        return recursion(i + 1, n, result)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val `in` = Scanner(System.`in`)
        val n = `in`.nextLine().toInt()
        val list = ArrayList<String>().apply {
            add("a")
            add("e")
            add("i")
            add("o")
            add("u")
        }

        val result = if (n == 1) list else recursion(2, n, list)

        result.forEach {
            print(it)
        }

        println(result.size)
    }
}