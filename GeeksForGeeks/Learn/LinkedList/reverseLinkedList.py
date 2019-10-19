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

    def pushFront(self, new_data):
        new_node = Node(new_data)
        new_node.next = self.head
        self.head = new_node

    def show(self):
        temp = self.head
        while(temp != None):
            print(temp.data, end='->')
            temp = temp.next
        print(temp)

    def pushBack(self, new_data):
        new_node = Node(new_data)
        temp = self.head
        while (temp.next != None):
            temp = temp.next
        temp.next = new_node

    def reverse(self):
        curr = self.head
        prev = None
        next = None

        while (curr != None):
            next = curr.next
            curr.next = prev
            prev = curr
            curr = next
        
        self.head = prev
        self.show()

if __name__ == '__main__':
    ll = LinkedList()
    ll.pushFront(4)
    ll.pushFront(2)
    ll.pushFront(1)
    
    ll.pushBack(5)
    ll.pushBack(6)

    ll.pushFront(3)

    # Normal Linked List 
    print('Normal Linked List')
    ll.show()

    # Reversed Linked List
    print('Reverse Linked List')
    ll.reverse()
