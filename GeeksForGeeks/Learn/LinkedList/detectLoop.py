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



    # To print the linked list
    def printList(self):
        temp = self.head
        while(temp != None):
            print(temp.data, end='->')
            temp = temp.next
        print(temp)



    #Method 1: Use Hashing to detect the loop in linked list
    def detectLoop(self):
        """
        Detecting a Loop by using Hashing
        """
        s = set()
        temp = self.head
        while (temp != None):
            if temp in s:
                print('Loop found at {}'.format(temp.data))
                return
            s.add(temp)
            temp = temp.next
        print('No loop is there')
        return 

    # Method 2: Using Mark Visited Nodes to finding a loop.
    # Add visited flag in Node class. While traversing, keep marking visited nodes.
    # If you see visited node again then there is a loop otherwise No loop is there.

    # Method 3: Using Floyd's Cycle-Finding Algorithm to finding a loop
    def detectLoop2(self):
        """
        Detecting a loop by using Floyd's Cycle-Finding algorithm
        """
        slow = self.head
        fast = self.head
        while (slow and fast and fast.next):
            slow = slow.next
            fast = fast.next.next

            if slow == fast:
                print('Loop found at %d' % (slow.data))
                return
        
        print('No loop found')
        return



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



    llist.head.next.next.next.next.next.next.next.next.next = llist.head

    print('\nDetect Loop in Linked List by Hashing')
    llist.detectLoop()

    print("\nDetect Loop in Linked List by Floyd's Cycle-Finding algorithm")
    llist.detectLoop2()