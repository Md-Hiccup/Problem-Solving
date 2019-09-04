"""     PROBLEM: ROMAN TO INTEGER
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9. 
    X can be placed before L (50) and C (100) to make 40 and 90. 
    C can be placed before D (500) and M (1000) to make 400 and 900.

Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3

Example 2:

Input: "IV"
Output: 4

Example 3:

Input: "IX"
Output: 9

Example 4:

Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

"""


class Solution:
    def romanToInt(self, s: str) -> int:
        roman = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }
        total = []
        i = 0
        l_str = list(s)
        while (i < len(l_str)):
            n = 0
            if i != len(s) - 1 and l_str[i] == 'I':
                if l_str[i + 1] == 'V':
                    n = 4
                elif l_str[i + 1] == 'X':
                    n = 9
                if n in [4, 9]:
                    i = i+2 
            elif i != len(s) - 1 and l_str[i] == 'X':
                if l_str[i + 1] == 'L':
                    n = 40
                elif l_str[i + 1] == 'C':
                    n = 90
                if n in [40, 90]:
                    i = i+2 
            elif i != len(s) - 1 and l_str[i] == 'C':
                if l_str[i + 1] == 'D':
                    n = 400
                elif l_str[i + 1] == 'M':
                    n = 900
                if n in [400, 900]:
                    i = i+2 
            if n == 0:
                n = roman[l_str[i]]
                i += 1
            total.append(n)
        return sum(total)


prob = Solution()

# test 1
test1 = 'III'
print('test1: {} -> {}'.format(test1, prob.romanToInt(test1)))

# test 2
test2 = 'IV'
print('test2: {} -> {}'.format(test2, prob.romanToInt(test2)))

# test 3
test3 = 'MMMCMLXXVII'
print('test3: %s -> %d' % (test3, prob.romanToInt(test3)))