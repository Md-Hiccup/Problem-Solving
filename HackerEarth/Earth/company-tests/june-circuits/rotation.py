"""
Rotation
Max. Marks: 100
You are given two strings S and T of the same length N. Your task is to convert the string S into T by doing some operations. In an operation, you can delete the first character of the string S and append any character at the end of the string. You are required to determine the minimum number of operations to convert S into T.

Input format

First line: Single integer N denoting the length of the strings
Second line: String S
Third line: String T
Output format
Print a single integer that represents the answer to the question.

Constraints
1 <= N <= 10^3
Both strings consist of only lowercase alphabets.

Input:
7
aaxaabc
aabcaax

Output
3
"""

# Write your code here
# n = int(input())
# s = input()
# new = input()

n = 7
string = 'caaxaab'
match_key = 'aabcaax'

count = 0
l = len(string)

while (count < l):
    print(string, match_key)
    if string == match_key:
        break
    else:
        d = list(string)
        pop = d.pop(0)
        d.append(pop)
        string = ''.join(d)
        count += 1

if count == l:
    print(0)
else:
    print(count)
