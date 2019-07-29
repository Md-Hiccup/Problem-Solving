"""
collections.DefaultDict():
The defaultdict tool is a container in the collections class of Python. It's similar to the usual dictionary (dict) container, but the only difference is that a defaultdict will have a default value if that key has not been set yet.

Sample Input
5 2
a
a
b
a
b
a
b

Sample Output
1 2 4
3 5

Explanation
'a' appeared  times in positions ,  and . 
'b' appeared  times in positions  and . 
In the sample problem, if 'c' also appeared in word group , you would print .
"""

from collections import defaultdict

n, m = map(int, input().split())
list_n = defaultdict(list)
for i in range(n):
    list_n[input()].append(i+1)

list_m = [input() for i in range(m)]
for i in list_m:
    if i in list_n:
        print(*list_n[i])   
    else:
        print(-1)

