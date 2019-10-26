"""
Sort two sorted linked list
A = 5 -> 10 -> 15
B = 2 -> 3 -> 20

O/p = 2 -> 3 -> 5 -> 10 -> 15 -> 20
"""

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


class LinkedList:
    def __init__(self):
        self.head = None

    def push(self, data):
        new_node = Node(data)
        new_node.next = self.head
        self.head = new_node
    
    def pushEnd(self, data):
        new_node = Node(data)
        temp = self.head

        if temp is None:
            self.head = new_node
            return

        while (temp.next != None):
            temp = temp.next
        temp.next = new_node
    
    def printList(self):
        temp = self.head
        while (temp != None):
            print(temp.data, end=' -> ')
            temp = temp.next
        print(temp)

    def copy(self):
        temp = self.head
        res = LinkedList()
        while (temp != None):
            res.pushEnd(temp.data)
            temp = temp.next

        return res


class SortList:
    def sort(self, listA, listB):
        dummy = Node(0)
        tail = dummy

        while (1):
            if listA is None:
                tail.next = listB
                break
            if listB is None:
                tail.next = listA
            
            if listA.data <= listB.data:
                tail.next = listA
                listA = listA.next
            else:
                tail.next = listB
                listB = listB.next
            
            tail = tail.next
        return dummy.next

    def recursiveSort(self, head1, head2): 
        temp = None
        if head1 is None: 
            return head2 
        if head2 is None: 
            return head1 
        if head1.data <= head2.data: 
            temp = head1 
            temp.next = self.recursiveSort(head1.next, head2) 
        else: 
            temp = head2 
            temp.next = self.recursiveSort(head1, head2.next) 
        return temp 


if __name__ == '__main__':
    llist1 = LinkedList()
    llist1.push(15)
    llist1.push(10)
    llist1.push(5)

    llist2 = LinkedList()
    llist2.push(20)
    llist2.push(3)
    llist2.push(2)


    # Copy the Linked List
    llist1_copy = llist1.copy()
    llist2_copy = llist2.copy()

    print('list A:', end='\t\t')
    llist1.printList()
    print('list B:', end='\t\t')
    llist2.printList()

    llist = SortList()

    #####   Use Either Recursive or Normal Sorting at a time    #####

    print('\nAfter sorting two list')
    llist3 = LinkedList()
    llist3.head = llist.sort(llist1.head, llist2.head)
    llist3.printList()

    print('\nRecursive Sorting of two list')
    llist4 = LinkedList()
    llist4.head = llist.recursiveSort(llist1_copy.head, llist2_copy.head)
    llist4.printList()
    
    print('\nAfter Sorting: list A, list B')
    print('list A:', end='\t\t')
    llist1.printList()
    print('list B:', end='\t\t')
    llist2.printList()

    print('\nAfter Sorting copy: list A, list B')
    print('list A:', end='\t\t')
    llist1_copy.printList()
    print('list B:', end='\t\t')
    llist2_copy.printList()
