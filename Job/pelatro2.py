"""
You are given Q queries, each of which will be one of the following:
Type 1: 1 L R 
Print the sum of the strength of all the array elements in the range [L, R] in a new line.
Type 2: 2 X P 
Update value of A[P] to X. 


Sample Input
5 3
5 6 4 6 5
2 4 1
1 7 9
1 1 5

Sample Output
0
3

Query 1: 
Array becomes [4, 6, 4, 6, 5]. 

Query 2: 
No numbers in the range [7, 9]. So the answer is 0. 

Query 3: 
Numbers in the range [1, 5] are: [4, 4, 5]. 
Strength of [4, 4, 5] are [1, 1, 1]. 
So the answer is 3. 
"""

size = list(map(int, input().split()))
T = size[1]
arr = list(map(int, input().split()))
res = []
for _ in range(T):
    nd = list(map(int, input().split()))
    if nd[0] == 2:
        # X, P = nd[1], nd[2]
        arr[nd[2]-1] = nd[1]
    elif nd[0] == 1:
        # L, R = nd[1], nd[2]
        co = [1 for i in arr if i in range(nd[1], nd[2]+1) ]
        res.append(co)

for i in res:
    print(len(i))