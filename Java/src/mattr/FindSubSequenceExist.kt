package mattr

fun main(vararg args: String) {
    // Do your processing here and print strings to satisfy the test cases
    val input = readLine()
    val sequence = readLine()!!

    sequence.split(" ").toList().findSubsequence().forEach {
        print(it)
        print(" ")
    }
}

fun List<String>.findSubsequence(): List<Int> {
    val sequence = this
    val lis = IntArray(sequence.size) { 1 }
    val lastIndex = IntArray(sequence.size) { -1 }

    for (i in 1 until sequence.size) {
        for (j in 0 until i) {
            if (sequence[j].toInt() < sequence[i].toInt() && lis[j] + 1 > lis[i]) {
                lis[i] = lis[j] + 1
                lastIndex[i] = j
            }
        }
    }

    val longestIS = ArrayList<Int>()
    var index = sequence.lastIndex
    while (index >= 0) {
        longestIS.add(sequence[index].toInt())
        index = lastIndex[index]
    }

    longestIS.reverse()
    return longestIS
}