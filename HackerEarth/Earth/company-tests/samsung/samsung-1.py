""" Bit even arrays

You are given an array A with entries A(i). Some of the entries in the array have The value of A(i) in some of the entries is equal to -1. This means that A(i) should be replaced by a bit even number.
A bit even number satisfies two properties:

1. All the bits at the odd position of the binary representation of that number are 0. For example, 2=(10)base2 satisfies this property because the bits    in positions 1, 3,.. are 0. Similarly, 8=(1000)base2 and 10=(1010)base2  also satisfy this property.
2. A(i) >= A(i-1)  and A(0) != -1.

Your task is to generate an array A by replacing A(i)=-1 with bit even numbers such that the sum of all the elements of the array is minimized. You are required to print the minimum sum possible based on the given constraints.

Input format

First line: T denoting the number of test cases
For each test case:
First line: A single integer N denoting the size of the array A
Next line: N space-separated integers corresponding to A(i)
Output format

For each test case, print a single integer denoting the minimum sum possible based on the given constraints.

Constraints
1 <= T <= 50
1 <= N <= 10^4
-1 <= A(i) <= 10^9

Sample Input
1
8
1 5 -1 25 -1 7 35 -1
Sample Output
153

Explanation
Index 2: Replace -1 by 8 = (1000)base2.  As 8>=5 AND Odd bits in binary representation of 8 are 0. 
Index 4: Replace -1 by 32 = (1000000)base2.  As 32>=25 AND Odd bits in binary representation of 32 are 0. 
Index 7: Replace -1 by 40 = (101000)base2.  As 40>=35 AND Odd bits in binary representation of 40 are 0.

Minimum sum possible: 1 + 5 + 8 + 25 + 32 + 7 + 35 + 40 = 153.
"""
def checkBit(val):
    b = bin(val).split('0b')[1]     #   0b100
    lb = list(map(int, b))          #   [1, 0, 0]
    for i in range(len(lb)-1, -1, -2):
        if i == 0:
            return False
        if lb[i] == 1:
            return False
    return True

def check(X):
    while (checkBit(X) != True):
        X += 1
    return X

if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        N = int(input())
        A = list(map(int, input().split()))
        for i in range(N):
            if A[i] == -1:
                d = check(A[i - 1]+1)
                A[i] = d
        print(A)
        print(sum(A))