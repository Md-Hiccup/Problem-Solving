"""
Sample Input
HACK 2

Sample Output
AC
AH
AK
CA
CH
CK
HA
HC
HK
KA
KC
KH
"""
# Enter your code here. Read input from STDIN. Print output to STDOUT
from itertools import permutations

if __name__ == "__main__":
    string, n = input().split()
    
    # Way 1
    # string = inp[0]
    # n = int(inp[1])
    # ls = list(permutations(string, n))
    # ls.sort()
    # for k in ls:
        # print(''.join(k))

    # Way 2
    print(*[''.join(k) for k in permutations(sorted(string), int(n))], sep='\n')
