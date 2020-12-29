package hackerrank

//import com.sun.xml.internal.ws.streaming.XMLStreamReaderUtil.close
import java.util.*


/**
 * Created by dastaniqbal on 19/07/2019.
 * ask2iqbal@gmail.com
 * 19/07/2019 5:20
 */

/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */

fun checkChar(str1:String,str2:String):Boolean{
    var flag=true
    str2.forEach{
        if(str1.indexOf(it)==-1)
            flag=false
    }
    return flag
}

fun main(args: Array<String>) {
    var s="kkkk"
    val len=s.length
    val halfLen=Math.ceil(s.length/2.0).toInt()
    var i=0
    var lastIndex=1
    var index=lastIndex
    var curStr=s.substring(i,index)
    var compareStr:String
    var pairs=0
    do{
        i++
        index++
        compareStr=s.substring(i,index)
        println("$curStr $compareStr $i $index")
        if(checkChar(curStr,compareStr)){
            pairs++
            println("Pair found $pairs")
        }
        if(index==len){
            i=0
            lastIndex++
            index=lastIndex
            curStr=s.substring(i,index)
            println("Reset $i $index $lastIndex $curStr")
        }
//         if(i > halfLen) break
    }while(curStr!=s)

    println(pairs)
}

internal class Calculator {
    fun power(n: Int, p: Int): Int {
        if (n < 0 || p < 0) {
            throw Exception("n and p should be non-negative")
        }
        val result = Math.pow(n.toDouble(), p.toDouble())
        return result.toInt()
    }
}

internal object Solution {

    @JvmStatic
    fun main(args: Array<String>) {

        val `in` = Scanner(System.`in`)
        var t = `in`.nextInt()
        while (t-- > 0) {

            val n = `in`.nextInt()
            val p = `in`.nextInt()
            val myCalculator = Calculator()
            try {
                val ans = myCalculator.power(n, p)
                println(ans)
            } catch (e: Exception) {
                println(e.message)
            }

        }
        `in`.close()
    }
}
