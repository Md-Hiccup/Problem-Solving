"""
Sample Input
4 
a a c d
2

Sample Output
0.8333

Explanation

All possible unordered tuples of length  comprising of indices from  to  are:
(1, 2) (1, 3) (1, 4) (2, 3) (2, 4) (3, 4)

Out of these 6 combinations, 5 of them contain either index 1 or index 2 which are the indices that contain the letter 'a'.

Hence, the answer is 5/6.
"""
from itertools import combinations, count

# length           #   4               9
# string           # 'a a c d'    'a b c a d b z e o'
# indices          #   2               4
# occur count      #  5/6           91/126
# output           #  0.8333        0.7222

l = 9
string = 'a b c a d b z e o'.split()
indices = 4

# length = int(input())
# string = input().split()
# indices = int(input())

comb = list(combinations(string, indices))
count = 0
for i in comb:
    if 'a' in i:
        count = count + 1
print("%.3f"%(count/len(comb)))