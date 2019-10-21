# Class for creating a Node
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class LinkedList:
    def __init__(self):
        self.head = None

    # To add a node at the front of the linked list
    def pushFront(self, new_data):
        """
        To add the node at the beginning of the linked list
        """
        root = self.head
        new_node = Node(new_data)
        new_node.next = root
        self.head = new_node

    # To add a node at the last of the linked list
    def pushEnd(self, new_data):
        """
        To add the node at the ending of the linked list
        """
        temp = self.head
        new_node = Node(new_data)
        while(temp.next != None):
            temp = temp.next
        temp.next = new_node

    # To add a node after the give data
    def pushAfter(self, prev_data, new_data):
        """
        To add the node, after the give prev_node
        """
        temp = self.head
        new_node = Node(new_data)

        while(temp.data != prev_data):
            temp = temp.next
        new_node.next = temp.next
        temp.next = new_node

    #Method 1: To reverse the linked list
    def reverse(self):
        """
        Iterative method to print the middle of the linked list
        """
        curr = self.head
        prev = None
        while(curr != None):
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        self.head = prev


    #Method 2: To Recursive Reverse of the linked list
    def reverseRecursive(self, curr, prev):
        """
        Recursive Function to print the middle of the linked list
        """
        if curr.next is None:
            self.head = curr
            curr.next = prev
            return
        
        next = curr.next
        curr.next = prev

        self.reverseRecursive(next, curr)

    def recursRev(self):
        if self.head is None:
            return
        self.reverseRecursive(self.head, None)
        

    # Method 1: To Find Middle of the linked list
    def printMiddle(self):
        """
        two pointer slow & fast.
        slow = slow.next
        fast = fast.next.next
        Once fast react to end, slow will reach to middle
        """
        slow = self.head
        fast = self.head
        while (fast is not None and fast.next != None):
            slow = slow.next
            fast = fast.next.next
        
        print(slow.data)
        
    # Method 2: To Find Middle of the linked list
    def printMiddle2(self):
        """
        set mid to mid.next when count is odd, when count reach to end mid will traverse half.
        """
        count = 0
        temp = self.head
        mid = self.head
        while (temp != None):
            if count & 1:           # count % 2 == 1
                mid = mid.next
            temp = temp.next
            count += 1
        print(mid.data)

    # Method 3: To find Middle of the Linked list
    def printMiddle3(self):
        """
        Iterative Method to find the middle of the linked list.
        """
        temp = self.head
        count = 0
        while (temp != None):
            temp = temp.next
            count += 1
        
        start = self.head
        mid = count // 2
        while (mid):
            start = start.next
            mid -= 1
        
        print(start.data)

    # To print the linked list
    def printList(self):
        temp = self.head
        while(temp != None):
            print(temp.data, end='->')
            temp = temp.next
        print()



if __name__ == '__main__':
    llist = LinkedList()
    # Push in Front of the list
    llist.pushFront(1)
    llist.pushFront(2)
    llist.pushFront(3)
    llist.pushFront(4)
    llist.pushFront(5)

    # Push at the End of the list
    llist.pushEnd(0)
    llist.pushEnd(-1)
    llist.pushEnd(-2)

    # Push After the previous node.
    llist.pushAfter(4, 40)
    llist.pushAfter(3, 30)

    print('Linked List')
    llist.printList()

    llist.reverse()

    print('\nNormal reverse of Linked List')
    llist.printList()

    print('\nRecursive reverse of Linked List')
    llist.recursRev()
    llist.printList()

    print('\nMiddle of the Linked List')
    llist.printList()
    llist.printMiddle()

    print('\nRecursive method to find the middle of the linked list')
    llist.printList()
    llist.printMiddle2()

    print('\nIterative Method for finding middle of the linked list')
    llist.printList()
    llist.printMiddle3()