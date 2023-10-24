package mattr

fun main(vararg args: String) {
    // Do your processing here and print strings to satisfy the test cases
    val str = readLine()!!
    println(validateAnagram(str))
}

fun validateAnagram(str: String): Boolean {
    val splitStr = str.split(" ")
    return if(splitStr.size >=2){
        val aStr = splitStr[0]
        val bStr = splitStr[1]
        val anagramList = arrayListOf<String>()
        aStr.forEach {
            anagramList.add(it.toString())
        }
        bStr.forEach {
            if(anagramList.contains(it.toString())){
                anagramList.remove(it.toString())
            }
        }
        anagramList.isEmpty()
    }else{
        false
    }
}