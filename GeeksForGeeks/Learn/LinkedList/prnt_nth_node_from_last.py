"""
Print the nth node from last in Linked List
"""

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
    
class LinkedList:
    def __init__(self):
        self.head = None

    def pushBack(self, new_data):
        temp = self.head
        new_node = Node(new_data)
        if temp is None:
            self.head = new_node
            return
        
        while (temp.next != None):
            temp = temp.next
        
        temp.next = new_node
    
    def printList(self):
        temp = self.head
        while (temp != None):
            print(temp.data, end='->')
            temp = temp.next
        print(temp)

    # Method 1
    # By counting the lenght of linked list
    # then traverse till the position and print the data
    def printNthFromLast(self, pos):
        temp = self.head
        count = 0
        while (temp != None):
            temp = temp.next
            count += 1
        
        if pos > count:
            print('Position is greater than the length of the linked list')
        
        temp = self.head

        for i in range(0, count - pos):
            temp = temp.next
        print(temp.data)

    
    # Method 2
    # 
    def printNthFromLast2(self, pos):
        ref = self.head
        main = self.head
        count = 0
        if self.head is None:
            return

        while (count < pos):
            if ref is None:
                print('%d is greater than the no. of nodes in linked list' % pos)
                return
            ref = ref.next
            count += 1
        
        while (ref != None):
            ref = ref.next
            main = main.next
        
        if main:
            print(main.data)
        else:
            print('%d is not a correct postion of nodes ' %pos)



if __name__ == '__main__':
    llist = LinkedList()
    llist.pushBack(21)
    llist.pushBack(32)
    llist.pushBack(43)
    llist.pushBack(24)
    llist.pushBack(22)

    llist.printList()

    # Method 1
    llist.printNthFromLast(3)

    # Method 2
    llist.printNthFromLast2(1)