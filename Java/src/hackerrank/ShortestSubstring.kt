package hackerrank

/**
 * Created by dastaniqbal on 09/07/2019.
 * ask2iqbal@gmail.com
 * 09/07/2019 10:22
 */

fun shortestSubstring(s: String): Int {
    val chars = ArrayList<Char>()
    s.forEach {
        if (!chars.contains(it)) {
            chars.add(it)
        }
    }

    val charMap = HashMap<Char, Int>()
    chars.forEach {
        charMap[it] = 0
    }

    var firstChar: Char
    var result = ""
    var start = 0
    var ucount = 0

    for (i in 0 until s.length) {
        val c = s[i]

        if (!charMap.containsKey(c)) {
            continue
        }


        val ccount = charMap[c]
        if (ccount == 0) {
            ucount += 1
        }

        charMap[c] = charMap[c]!! + 1

        while (ucount == chars.size) {

            if (result == "" || (i - start + 1) < result.length)
                result = s.substring(start, i + 1)

            firstChar = s[start]

            if (charMap.containsKey(firstChar)) {
                val headCount = charMap[firstChar]!! - 1
                if (headCount == 0) {
                    ucount -= 1
                }
                charMap[firstChar] = headCount
            }
            start += 1
        }
    }
    return result.length
}

fun main(args: Array<String>) {
    val s = readLine()!!
    val result = shortestSubstring(s)
    println(result)
}

