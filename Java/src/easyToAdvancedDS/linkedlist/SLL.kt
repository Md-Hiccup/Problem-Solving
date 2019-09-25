package easyToAdvancedDS.linkedlist

/**
 * Created by dastaniqbal on 11/09/2019.
 * ask2iqbal@gmail.com
 * 11/09/2019 3:51
 *
 * Singly Linked List
 */

data class Node<T>(var ele: T, var next: Node<T>?)

class SLL<T> {
    var head: Node<T>? = null

    fun add(value: T): SLL<T> {
        if (head == null) {
            head = Node(value, null)
        } else {
            var trav = head
            while (trav?.next != null) {
                trav = trav.next
            }
            trav?.next = Node(value, null)
        }
        return this
    }

    fun insertBefore(value: T, beforeValue:T): SLL<T> {
        if (head == null) throw IllegalArgumentException("List is empty")
        var trav = head

        //First Element
        if (trav?.ele == beforeValue) {
            val node = Node(value, null)
            node.next = trav
            head = node
        } else {
            while (trav != null) {
                if (trav.next?.ele == beforeValue) {
                    val tmpTrav = trav.next
                    val node = Node(value, null)
                    trav.next = node
                    node.next = tmpTrav
                    trav = trav.next?.next
                } else {
                    trav = trav.next
                }
            }
        }
        return this
    }

    fun remove(value: T): SLL<T> {
        if (head == null) throw IllegalArgumentException("List is empty")
        var trav = head

        if (trav?.ele == value) {
            head = trav?.next
        } else {
            while (trav != null) {
                if (trav.next?.ele == value) {
                    val tmpTrav = trav.next?.next
                    trav.next = tmpTrav
                }
                trav = trav.next
            }
        }
        return this
    }

    override fun toString(): String {
        var trav = head
        val string = StringBuilder()
        string.append("[")

        while (trav != null) {
            string.append(trav.ele)
            trav = trav.next
            if (trav != null)
                string.append(",")
        }

        string.append("]")
        return string.toString()
    }
}


fun main(args: Array<String>) {
    val sll = SLL<Int>()
    sll.add(1).add(3).add(4).add(6)
    println("Added into List $sll")

    sll.insertBefore(0, 1)
    println("Insert 0 before 1 in SLL(Begin) $sll")

    sll.insertBefore(2, 3)
    println("Insert 2 before 3 in SLL(Middle) $sll")

    sll.insertBefore(5, 6)
    println("Insert 2 before 3 in SLL(End) $sll")

    sll.remove(0)
    println("Removing 0 in beginning $sll")

    sll.remove(3)
    println("Removing 3 in middle $sll")

    sll.remove(6)
    println("Removing 6 in end $sll")


}