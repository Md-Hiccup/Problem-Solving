"""
Sample Input
HACK 2

Sample Output
AA
AC
AH
AK
CC
CH
CK
HH
HK
KK
"""

# Enter your code here. Read input from STDIN. Print output to STDOUT
from itertools import combinations_with_replacement

string, n = input().split()

print(*[''.join(i) for i in combinations_with_replacement(sorted(string), int(n))], sep='\n')
