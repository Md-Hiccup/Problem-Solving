"""
Output Format
Output a single integer denoting the value S(max).

Sample Input
(A)
3 1000
2 5 4
3 7 8 9 
5 5 7 8 9 10 

Sample Output
206
Explanation

Picking 5 from the 1st list, 9 from the 2nd list and 10 from the 3rd list gives the maximum S value equal to 
(5^2 + 9^2 + 10^2) % 1000 = 206.
"""
from itertools import product

# Enter your code here. Read input from STDIN. Print output to STDOUT
# n, k = 7, 867
# a = list(map(int, "7 6429964 4173738 9941618 2744666 5392018 5813128 9452095".split()))
# b = list(map(int, "7 6517823 4135421 6418713 9924958 9370532 7940650 2027017".split()))
# c = list(map(int, "7 1506500 3460933 1550284 3679489 4538773 5216621 5645660".split()))
# d = list(map(int, "7 7443563 5181142 8804416 8726696 5358847 7155276 4433125".split()))
# e = list(map(int, "7 2230555 3920370 7851992 1176871 610460 309961 3921536".split()))
# f = list(map(int, "7 8518829 8639441 3373630 5036651 5291213 2308694 7477960".split()))
# g = list(map(int, "7 7178097 249343 9504976 8684596 6226627 1055259 4880436".split()))
#   answ = 866

n, k = 6, 767
a = list(map(int, "2 488512261 423332742".split()))
b = list(map(int, "2 625040505 443232774".split()))
c = list(map(int, "1 4553600".split()))
d = list(map(int, "4 92134264 617699202 124100179 337650738".split()))
e = list(map(int, "2 778493847 932097163".split()))
f = list(map(int, "5 489894997 496724555 693361712 935903331 518538304".split()))
#   ans = 763

arr = [a[1:], b[1:], c[1:], d[1:], e[1:], f[1:]]

# inp = input().split()
# n, k = int(inp[0]), int(inp[1])
# arr = [list(map(int, input().split()[1:])) for i in range(n)]
# print(*arr, sep='\n')

max_val = 0
for i in product(*arr):
    m = sum(list(map(lambda x: pow(x, 2), i))) % k
    if max_val < m :
        max_val = m
print(max_val)