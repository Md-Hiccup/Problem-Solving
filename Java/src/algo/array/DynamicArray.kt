package algo.array

/**
 * Created by dastaniqbal on 11/09/2019.
 * ask2iqbal@gmail.com
 * 11/09/2019 3:11
 *
 * Dynamic Array Sample
 */

class DynamicArray<T> {
    var capacity: Int
    var len = 0
    var arr: Array<Any?>

    constructor() : this(16)

    constructor(size: Int) {
        if (size < 1) throw IllegalArgumentException(" size must be positive")
        capacity = size
        arr = arrayOfNulls<Any>(size)
    }

    fun clear() {
        arr.forEachIndexed { index, any ->
            arr[index] = null
        }
        len = 0
    }

    fun add(ele: T): DynamicArray<T> {
        if (len + 1 == capacity) {
            capacity *= 2
            val arrCpy = arrayOfNulls<Any>(capacity)
            arrCpy.forEachIndexed { index, any ->
                if (index < arr.size)
                    arrCpy[index] = arr[index]
            }
            arr = arrCpy
        }
        arr[len++] = ele
        return this
    }

    fun removeAt(ele: T) {
        val arrCpy = arrayOfNulls<Any>(capacity)
        var j = 0
        for (i in 0 until arr.size) {
            if (arr[i] != ele)
                arrCpy[j++] = arr[i]
        }
        arr = arrCpy
    }

    fun remove(index: Int) {
        val ele = arr[index]
        removeAt(ele as T)
    }

    override fun toString(): String {
        return arr.joinToString(",")
    }
}

fun main(args: Array<String>) {
    val intArray = DynamicArray<Int>(3)

    intArray.add(3).add(2).add(1).add(4)
    println("Elements add $intArray")

    intArray.removeAt(4)
    println("Elements removeAt $intArray")

    intArray.remove(4)
    println("Elements removeAt $intArray")
}