"""
Sample Input
HACK 2

Sample Output
A
C
H
K
AC
AH
AK
CH
CK
HK
"""
# Enter your code here. Read input from STDIN. Print output to STDOUT
from itertools import combinations

string, n = input().split()
for i in range(1, int(n)+1):
    for j in combinations(sorted(string), i):
        print(''.join(j))

# print(*[''.join(k) for k in combinations(sorted(string), int(n))], sep='\n')