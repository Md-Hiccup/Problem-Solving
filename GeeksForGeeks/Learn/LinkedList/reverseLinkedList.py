"""
To reverse a Linked List

I/p =   1 -> 2 -> 3 -> Null

O/p =   3 -> 2 -> 1 -> Null
"""

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
        self.printList()

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
        self.printList()

        # To print the linked list
    def printList(self):
        temp = self.head
        while(temp != None):
            print(temp.data, end='->')
            temp = temp.next
        print(temp)

if __name__ == '__main__':
    ll = LinkedList()
    ll.pushFront(4)
    ll.pushFront(2)
    ll.pushFront(1)
    
    ll.pushEnd(5)
    ll.pushEnd(6)

    ll.pushFront(3)

    # Normal Linked List 
    print('Normal Linked List')
    ll.printList()

    # Reversed Linked List
    print('Reverse Linked List')
    ll.reverse()
