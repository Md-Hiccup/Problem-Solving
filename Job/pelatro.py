"""
Size of the Matrix is N x M
The upper left and lower right indexes of 4 submatrices formed are:
1.  (0,0)       -   (N/2-1, M/2-1)
2.  (0,M/2)     -   (N/2-1, M-1)
3.  (N/2,M/2)   -   (N-1, M-1)
4.  (N/2,0)     -   (N-1, M/2-1)

INPUT
1
4 4
1 3 5 2
6 7 -3 -10
15 14 -1 12
1 3 1 3

OUTPUT
78 
After changing A[0][2] from 2 to 24 => 36 Find minimum.
"""

# def nestedList(nl):
#     for i in nl:
#         if isinstance(nl, list):
#             nestedList(nl)
#         else:
#             i

def solve(A, N, M):
    l1,l2,l3,l4 = [], [], [], []
    # Write your code here
    ne = []
    def nestedList(nl):
        for i in nl:
            if isinstance(i, list):
                nestedList(i)
            else:
                ne.append(i)
        return ne

    # Upper 
    for i in range(0,N//2):
        l1.append(A[i][0:(M // 2)])     # Upper Left
        l2.append(A[i][M // 2:M])       # Upper Right
        
    # print('l1: ', nestedList(l1))
    # print('l2: ',nestedList(l2))
    p1 = sum(nestedList(l1))
    ne = []
    p2 = sum(nestedList(l2))

    # Lower    
    for i in range(N//2, N):            
        l3.append(A[i][M // 2:M])       # Lower Left
        l4.append(A[i][0:M//2])         # Lower Right
        
    # print('l3: ', nestedList(l3))
    # print('l4: ',nestedList(l4))
    ne = []        
    p3 = sum(nestedList(l3))
    ne = []
    p4 = sum(nestedList(l4))
    
    print(p1, p2, p3, p4)
    res = abs(p1-p2) + abs(p2-p3) + abs(p3-p4) + abs(p4-p1)
    
    return res

T = int(input())
for _ in range(T):
    size = list(map(int, input().split()))
    N, M = size[0], size[1]
    A = []
    for _ in range(N):
        A.append(list(map(int, input().split())))
    
    out_ = solve(A,N,M)
    
    # on Chaning a[0][2] = 24
    # A[0][3] = 24
    # out_ = solve(A,N,M)
    print (out_)