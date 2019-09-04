"""     PROBLEM: ADD TWO NUMBERS
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.



SOLUTIONS:

Keep track of the carry using a variable and simulate digits-by-digits sum starting from the head of list, which contains the least-significant digit.

Just like how you would sum two numbers on a piece of paper, we begin by summing the least-significant digits, which is the head of l1 and l2. Since each digit is in the range of 0…9, summing two digits may "overflow". For example 5+7=12. In this case, we set the current digit to 2 and bring over the carry=1 to the next iteration. carry must be either 0 or 1 because the largest possible sum of two digits (including the carry) is 9+9+1=19.

The pseudocode is as following:

    -   Initialize current node to dummy head of the returning list.
    -   Initialize carry to 0.
    -   Initialize p and q to head of l1 and l2 respectively.
    -   Loop through lists l1 and l2 until you reach both ends.
            Set x to node p's value. If p has reached the end of l1, set to 0.
            Set y to node q's value. If q has reached the end of l2, set to 0.
            Set sum=x+y+carry.
            Update carry=sum/10.
            Create a new node with the digit value of (sum mod 10) and set it to current node's next, then advance current node to next.
            Advance both p and q.
    -   Check if carry=1, if so append a new node with digit 1 to the returning list.
    -   Return dummy head's next node.

Note that we use a dummy head to simplify the code. Without a dummy head, you would have to write extra conditional statements to initialize the head's value.
"""


import json

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

def stringToIntegerList(input):
    return list(map(int, input.split(' ')))
    # return json.loads(input)

def stringToListNode(inp):
    # Generate list from the input
    numbers = stringToIntegerList(inp)

    # Now convert that list into linked list
    dummyRoot = ListNode(0)
    ptr = dummyRoot
    for number in numbers:
        ptr.next = ListNode(number)
        ptr = ptr.next

    ptr = dummyRoot.next
    return ptr
    

def listNodeToString(node):
    if not node:
        return "[]"

    result = ""
    while node:
        result += str(node.val) + ", "
        node = node.next
    return "[" + result[:-2] + "]"


class Solution:

    # Method 1
    def addTwoNumbers(self, l1, l2):
        dummyHead = ListNode(0)
        p, q, curr = l1, l2, dummyHead
        carry = 0
        while(p != None or q != None):
            x = p.val if p != None else 0
            y = q.val if q != None else 0
            total = carry + x + y
            carry = total // 10
            curr.next = ListNode(total % 10)
            curr = curr.next
            if p!=None:
                p = p.next
            if q!=None:
                q = q.next
        
        if carry > 0:
            curr.next = ListNode(carry)
        
        return dummyHead.next
            
            
    # Method 2 (Mine Method)
    # def addTwoNumbers(self, l1, l2):
    #     a1, a2 = "", ""
    #     while(l1 != None):
    #         a1 += str(l1.val)
    #         l1 = l1.next
    #     while(l2 != None):
    #         a2 += str(l2.val)
    #         l2 = l2.next

    #     a1,a2 = a1[::-1], a2[::-1]
    #     total_sum = str(int(a1) + int(a2))
    #     total = list(map(int, total_sum))
    #     total = total[::-1]
    #     # print(a1, a2, total)
    #     root = ListNode(0)
    #     dummy = root

    #     for i in range(0, len(total)):
    #         new_node = ListNode(total[i])
    #         dummy.next = new_node
    #         dummy = dummy.next

    #     return root.next


#   Test 1
list1 = stringToListNode('3 4 2')
list2 = stringToListNode('4 6 5')

prob1 = Solution().addTwoNumbers(list1, list2)
out = listNodeToString(prob1)
print(out)

#   Test 2
list1 = stringToListNode('8 1')
list2 = stringToListNode('0')

prob1 = Solution().addTwoNumbers(list1, list2)
out = listNodeToString(prob1)
print(out)