package hackerrank.warmup

/**
 * Created by dastaniqbal on 05/07/2019.
 * ask2iqbal@gmail.com
 * 05/07/2019 4:53
 */
import java.util.*
import kotlin.collections.ArrayList

/**
Test cases
10
0 0 1 0 0 0 0 1 0 0
0 1 2 3 4 5 6 7 8 9
Expected: 6

Iteration 0
c[0+2]==0 no its 1
c[0+1]==0 its 0 current+1=1 jump+1=1

Iteration 1
c[1+2]==0 its 0 current+2=3 jump+1=2

Iteration 2
c[3+2]==0 its 0 current+2=5 jump+1=3

Iteration 3
c[5+2]==0 no its 1
c[5+1]==0 its 0 current+1=6 jump+1=4

Iteration 4
c[6+2]==0 its 0 current 6+2=8 jump+1=5

Iteration 5
c[8+2]==0 doesn't exist
c[8+1]==0 its 0 current 8+1=9 jump+1=6


85
0 1 0 1 0 1 0 0 0 0 0 0 0 0 1 0 1 0 0 0 0 1 0 1 0 0 1 0 0 0 1 0 1 0 0 0 1 0 1 0 1 0 1 0 0 0 1 0 0 0 0 0 1 0 1 0 1 0 0 1 0 1 0 1 0 0 1 0 0 0 0 1 0 0 1 0 0 0 1 0 0 1 0 1 0
Expected:46

50
0 0 1 0 0 0 0 1 0 0 0 0 1 0 0 0 0 0 1 0 1 0 0 0 1 0 0 1 0 0 0 1 0 1 0 0 0 0 0 0 0 0 1 0 0 1 0 1 0 0
0 1 2 3 4 5 6 7 8 9101112   13141516171819202122232425262728293031323334353637383940414243444546474849
Expected:28

7
0 0 1 0 0 1 0
Expected: 4

6
0 0 0 1 0 0
Expected: 3
 */

// Complete the hackerrank.warmup.jumpingOnClouds function below.
fun jumpingOnClouds(c: Array<Int>): Int {
    var jump = 0
    var current = 0
    val n = Math.ceil(c.size / 2.0).toInt()
    for (i in 0..n) {
        if (current + 2 < c.size && c[current + 2] == 0) {
            current += 2
            jump++
        } else if (current + 1 < c.size && c[current + 1] == 0) {
            current += 1
            jump++
        }
    }
    return jump
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val c = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}
