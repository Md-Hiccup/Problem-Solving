"""     PROBLEM: PALLINDROME NUMBER
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true

Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.


SOLUTION:
Approach 1: Revert half of the number

Intuition

The first idea that comes to mind is to convert the number into string, and check if the string is a palindrome, but this would require extra non-constant space for creating the string which is not allowed by the problem description.

Second idea would be reverting the number itself, and then compare the number with original number, if they are the same, then the number is a palindrome. However, if the reversed number is larger than int.MAX\text{int.MAX}int.MAX, we will hit integer overflow problem.

Following the thoughts based on the second idea, to avoid the overflow issue of the reverted number, what if we only revert half of the int\text{int}int number? After all, the reverse of the last half of the palindrome should be the same as the first half of the number, if the number is a palindrome.

For example, if the input is 1221, if we can revert the last part of the number "1221" from "21" to "12", and compare it with the first half of the number "12", since 12 is the same as 12, we know that the number is a palindrome.

Let's see how we could translate this idea into an algorithm.

Algorithm

First of all we should take care of some edge cases. All negative numbers are not palindrome, for example: -123 is not a palindrome since the '-' does not equal to '3'. So we can return false for all negative numbers.

Now let's think about how to revert the last half of the number. For number 1221, if we do 1221 % 10, we get the last digit 1, to get the second to the last digit, we need to remove the last digit from 1221, we could do so by dividing it by 10, 1221 / 10 = 122. Then we can get the last digit again by doing a modulus by 10, 122 % 10 = 2, and if we multiply the last digit by 10 and add the second last digit, 1 * 10 + 2 = 12, it gives us the reverted number we want. Continuing this process would give us the reverted number with more digits.

Now the question is, how do we know that we've reached the half of the number?

Since we divided the number by 10, and multiplied the reversed number by 10, when the original number is less than the reversed number, it means we've processed half of the number digits.

"""

class Solution:
    def isPalindrome(self, x):
        # Approach 1
        if x < 0 or (x % 10 == 0 and x != 0):
            return False

        reverted = 0
        while (x > reverted):
            reverted = reverted * 10 + x % 10
            x //= 10
        
        return x == reverted or x == reverted//10
        
        
        # Approach 2
        # neg = False
        # if x < 0:
        #     neg = True
        # n = abs(x)
        # pal = 0
        # while(n):
        #     rem = n % 10
        #     pal = pal * 10 + rem
        #     n //= 10
        
        # if neg:
        #     return str(x) == pal
        # return x == pal

prob = Solution()

test1 = 121
print(prob.isPalindrome(test1))

test2 = -121
print(prob.isPalindrome(test2))

test3 = 123
print(prob.isPalindrome(test3))
