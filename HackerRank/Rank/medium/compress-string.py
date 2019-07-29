"""
from itertools import groupby
    # [k for k, g in groupby('AAAABBBCCDAABBB')] --> A B C D A B
    # [list(g) for k, g in groupby('AAAABBBCCD')] --> AAAA BBB CC D

First, the character 1 occurs only once. It is replaced by (1, 1). Then the character 2 occurs three times, and it is replaced by (3, 2) and so on.

Sample Input

1222311
Sample Output

(1, 1) (3, 2) (1, 3) (2, 1)
"""
# Enter your code here. Read input from STDIN. Print output to STDOUT
from itertools import groupby

inp = input()

# Way 1
# for i,j in groupby(inp):
    # print((len(list(j)), int(i)), end=' ')

# Way 2
print(*[(len(list(j)), int(i)) for i, j in groupby(inp)])