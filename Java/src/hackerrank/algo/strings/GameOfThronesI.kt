package hackerrank.algo.strings

import java.util.*
import kotlin.collections.HashSet

// Complete the gameOfThrones function below.
fun gameOfThrones(s: String): String {
    var len = s.length
    val hashMap = HashSet<Char>()
    s.forEachIndexed { i, c ->
        if (hashMap.contains(c)) {
            hashMap.remove(c)
        } else {
            hashMap.add(c)
        }
    }

    return when (hashMap.size) {
        0,1 -> "YES"
        else -> "NO"
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = gameOfThrones(s)

    println(result)
}
