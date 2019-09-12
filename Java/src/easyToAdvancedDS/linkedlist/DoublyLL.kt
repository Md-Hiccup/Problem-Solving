package easyToAdvancedDS.linkedlist

import java.lang.RuntimeException

/**
 * Created by dastaniqbal on 11/09/2019.
 * ask2iqbal@gmail.com
 * 11/09/2019 5:04
 *
 * Doubly Linked List
 */

data class NodeDLL<T>(var ele: Any?, var next: NodeDLL<T>?, var prev: NodeDLL<T>?)

class DoublyLL<T> {
    var head: NodeDLL<T>? = null
    var tail: NodeDLL<T>? = null
    var size = 0

    fun clear() {
        var trav = head
        while (trav != null) {
            val tmpTrav = trav.next
            trav.ele = null
            trav.prev = null
            trav.next = null
            trav = tmpTrav
        }
        size = 0
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    //O(1)
    fun add(node: NodeDLL<T>) {
        addLast(node)
    }

    //O(1)
    fun addLast(node: NodeDLL<T>) {
        if (isEmpty()) {
            head = node
            tail = node
        } else {
            tail?.next = node
            node.prev = tail
            tail = node
        }

        size++
    }

    //O(1)
    fun addFirst(node: NodeDLL<T>) {
        if (isEmpty()) {
            head = node
            tail = node
        } else {
            node.next = head
            head?.prev = node
            head = node
        }
        size++
    }

    fun add(element: Any): DoublyLL<T> {
        if (head == null) {  // O(1)
            head = NodeDLL<T>(element, null, null)
            tail = head
        } else {
            // O(n)
            var trav = head

            while (trav?.next != null) {
                trav = trav.next
            }

            val node = NodeDLL<T>(element, null, null)
            trav?.next = node
            node.prev = trav
            tail = node
        }

        size++
        return this
    }

    fun insert(element: Any, before: Any) {
        if (head?.ele == before) {
            // O(1)
            val tmpTrav = head
            val node = NodeDLL(element, head, null)
            tmpTrav?.prev = node
            head = node
            if (head?.next == null) {
                tail = head
            }
            size++
        } else {
            // O(n) Linear searching
            var trav = head
            while (trav != null) {
                if (trav.next?.ele == before) {
                    val tmpTrav = trav.next

                    val node = NodeDLL(element, tmpTrav, null)
                    tmpTrav?.prev = node

                    trav.next = node
                    node.prev = trav

                    //trav = trav.next?.next
                    size++
                    if (node.next == null) {
                        tail = node
                    }
                    break
                } else {
                    trav = trav.next
                }
            }
        }
    }

    //O(1)
    fun removeFirst(){
        if(isEmpty()) throw RuntimeException("List empty")

        head=head?.next
        head?.prev=null

        size--
    }

    //O(1)
    fun removeLast(){
        if(isEmpty()) throw RuntimeException("List empty")

        tail=tail?.prev
        tail?.next=null

        size--
    }

    fun remove(element: Any) {
        if (head?.ele == element) {
            // O(1)
            head = head?.next
            if (head?.next == null) {
                tail = head
            }
            size--
        } else {
            // O(n) Linear searching
            var trav = head
            while (trav != null) {
                if (trav.next?.ele == element) {
                    val tmpTrav = trav.next?.next
                    trav.next = tmpTrav
                    tmpTrav?.prev = trav
                    size--
                    if (trav.next == null) {
                        tail = trav
                    }
                    break
                }
                trav = trav.next
            }
        }
    }

    override fun toString(): String {
        var trav = head
        println("Head=${head?.ele} Tail=${tail?.ele} Size=${size}")
        val string = StringBuilder()
        string.append("[")

        while (trav != null) {
            string.append("{${trav.prev?.ele},${trav.ele},${trav.next?.ele}}")
            trav = trav.next
            if (trav != null)
                string.append(",")
        }

        string.append("]")
        return string.toString()
    }
}

fun main(args: Array<String>) {
    val dll = DoublyLL<Int>()

    dll.add(0).add(1).add(2).add(3).add(4).add(5)
    println("Adding 0,1,2,3,4,5")
    println(dll.toString())

    dll.add(6)
    println("Adding 6 at End")
    println(dll.toString())

    dll.remove(3)
    println("Removing 3 middle")
    println(dll.toString())

    dll.remove(6)
    println("Removing 6 at End")
    println(dll.toString())

    dll.insert(-1, 0)
    println("Inserting -1 begining")
    println(dll.toString())

    dll.insert(2, 2)
    println("Inserting 2 middle")
    println(dll.toString())

    dll.add(NodeDLL(6, null, null))
    println("Adding in Last 6")
    println(dll.toString())

    dll.clear()
    println("Clearing List")
    println(dll.toString())

    dll.addLast(NodeDLL(6, null, null))
    println("Adding in empty list 1")
    println(dll.toString())

    dll.addFirst(NodeDLL(-1, null, null))
    println("Adding in first -1")
    println(dll.toString())

    dll.removeFirst()
    println("removeFirst")
    println(dll.toString())

    dll.add(0).add(1).add(2).add(3).add(4).add(5)
    println("Adding 0,1,2,3,4,5")
    println(dll.toString())

    dll.removeLast()
    println("removeLast")
    println(dll.toString())
}