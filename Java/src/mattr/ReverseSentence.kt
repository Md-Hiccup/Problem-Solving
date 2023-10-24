package mattr

fun main(vararg args: String) {
    val number = readLine()!!
    val reverseList = arrayListOf<String>()
    repeat(number.toInt()) {
        val str = readLine()!!
        reverseList.add(str.reverseSentence())
    }

    reverseList.forEach {
        println(it)
    }
}

fun String.reverseSentence(): String {
    val splitString = this.split(" ")
    val builder = StringBuilder()
    val length = splitString.size -1
    for (i in length downTo 0) {
        builder.append(splitString[i])
        builder.append(" ")
    }
    return builder.toString()
}