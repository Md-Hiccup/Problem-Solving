"""
collections.Counter() 
A counter is a container that stores elements as dictionary keys, and their counts are stored as dictionary values.

Sample Input
10
2 3 4 5 6 8 7 6 5 18
6
6 55
6 45
6 55
4 40
18 60
10 50

Sample Output
200
"""
from collections import Counter
# Enter your code here. Read input from STDIN. Print output to STDOUT

#   .remove():  removes the first matching value, not a specific index.
#   del:        removes the item at a specific index
#   .pop()      removes the item at a specific index and return it.

total_shoe = 10
shoe_size = [2,3,4,5,6,8,7,6,5,18]
n = 6
cust = ['6 55', '6 45', '6 55', '4 40', '18 60', '10 50']

####    Way 2   ####
# total_shoe = int(input())
# shoe_size = Counter(map(int, input().split()))
# n = int(input())
income = 0

for _ in range(n):
    size, price = map(int, input().split())
    if shoe_size[size]:
        income += price
        shoe_size[size] -= 1
        
print(income)


####    Way 1   ####
# total_shoe = int(input())
# shoe_size = list(map(int, input().split()))
# n = int(input())
# cust = [input() for _ in range(n)]
# d = []
# for _ in cust:
#     d.append(tuple(map(int, _.split())))

# total = 0
# for i in d:
#     if i[0] in shoe_size:
#         ind = shoe_size.index(i[0])
#         total = total + i[1]
#         shoe_size.pop(ind)
# print(total)
        