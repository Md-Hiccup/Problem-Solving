package hackerrank.warmup

import java.util.*

fun sockMerchant(n: Int, ar: Array<Int>): Int {
    val hashMap=HashMap<Int,Int>()
    var pairs=0
    ar.forEachIndexed{index,value->
        if(hashMap.getOrDefault(value,0)==0){
            hashMap[value]=1
        }else if(hashMap.get(value)==1){
            pairs++
            hashMap.put(value,0)
        }
    }
    return pairs
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}
