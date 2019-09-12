object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val zlist = ArrayList<Int>()
        val arr = arrayOf(0, 9, 0, 2, 6, 8, 0, 8, 3, 0)

        arr.forEachIndexed { index, value ->
            if (index != 0 && value == 0)
                zlist.add(index)
        }
        var max = 0
        zlist.forEach {
            val result=getList(it, arr, false, 1)
            max = Math.max(result, max)
        }
        println(max)
    }

    fun getList(search: Int, arr: Array<Int>, oddVisited: Boolean, count: Int): Int {
        var oddVisited = oddVisited
        var count = count
        val zlist = ArrayList<Int>()
        arr.forEachIndexed { index, value ->
            if (index != 0 && value == search)
                zlist.add(index)
        }
        if (zlist.size > 0) {
            count++
            val value = zlist[0]
            if (value % 2 != 0) {
                if (oddVisited)
                    return count
                else{
                    oddVisited = true
                    getList(value, arr, oddVisited, count)
                }
            }else{
                getList(value, arr, oddVisited, count)
            }
        }
        return count
    }

}
