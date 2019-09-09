"""     PROBLEM: REVERSE INTEGER
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321

Example 2:

Input: -123
Output: -321

Example 3:

Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

"""


class Solution:
    def reverse(self, x: int) -> int:
        #   Approach 2
        INTMAX = +2147483647
        INTMIN = -2147483648

        rev = 0
        while (x != 0):
            pop = x % 10 if x > 0 else (x % 10) - 10
            x = x // 10 if x > 0 else (x // 10) + 1
            
            if (rev > INTMAX // 10 or (rev == INTMAX // 10 and pop > 7)):
                return 0
            
            if (rev < INTMIN // 10 or (rev == INTMIN // 10 and pop < -8)):
                return 0
            
            rev = rev * 10 + pop

        return rev

        #   Approach 1
        # l = ''
        # pos = True if x >= 0 else False
        # if x == 0:
        #     return x
        
        # x = abs(x)
        # while(x):
        #     l += str(x%10)
        #     x = x//10
            
        # if int(l) > 2**31-1 or int(l) < -2**31:
        #     return 0
        
        # if not pos:
        #     l = '-'+l
            
        # return int(l)


prob = Solution()

test1 = 123
print(prob.reverse(test1))

test2 = -123
print(prob.reverse(test2))

test3 = 120
print(prob.reverse(test3))

test4 = 123213245639
print(prob.reverse(test4))