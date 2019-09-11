"""
Today, Monk went for a walk in a garden. There are many trees in the garden and each tree has an English alphabet on it. While Monk was walking, he noticed that all trees with vowels on it are not in good state. He decided to take care of them. So, he asked you to tell him the count of such trees in the garden.
Note : The following letters are vowels: 'A', 'E', 'I', 'O', 'U' ,'a','e','i','o' and 'u'.

Input:
The first line consists of an integer T denoting the number of test cases.
Each test case consists of only one string, each character of string denoting the alphabet (may be lowercase or uppercase) on a tree in the garden.

Output:
For each test case, print the count in a new line

Constraints:
1 <= T <= 10
1 <= length of strings <= 10^5

INPUT:
2
nBBZLaosnm
JHkIsnZtTL

OUTPUT:
2
1
"""

# test 1
test1 = "nBBZLaosnm"

test2 = "JHkIsnZtTL"

# T = int(input())
T = 1
for _ in range(T):
    # text = input()
    text = test1        # or test2
    count = 0
    for i in text:
        if i in ['a', 'e', 'i', 'o', 'u', 'A', 'E', 'I','O', 'U']:
            count += 1
    print(count)


