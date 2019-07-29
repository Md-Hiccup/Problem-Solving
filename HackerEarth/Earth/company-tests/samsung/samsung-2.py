"""
Sorted arrays
You are given an array A of size N. A series of arrays is defined as follows:

X1 = A[1,2,3... , N] is repeated N times
X2 = A[1,2,3... , N/2] is repeated 2 * N times
X3 = A[1,2,3... , N/4]is repeated 3 * N times 
...
...
And so on
Note: The divisions N/2, N/4, are integer divisions.

An array B is defined as: 
B = Concatenate(X1, X2, X3, ..)

Now, the array B is sorted. Your task is to print the Kth element of the array B. If the size of B is less than K, then print -1.

Input format

First line: T denoting the number of test cases
For each test case:
First line: Contains the size of array N
Next line: N space-separated integers corresponding to A(i)
Next line: A single integer K
Output format

For each test case, print a single integer corresponding to Kth element of the sorted array B. 

Constraints
1 <= T <= 100
1 <= N <= 10^5
1 <= A(i) <= 10^9
1 <= K <= 10^18


Sample Input
2
3
1 2 3
15
4
1 2 3 4
15

Sample Output
3
1
Explanation

TEST CASE #1: 
X1={1,2,3,1,2,3,1,2,3}
X2={1,1,1,1,1,1}
B={1,1,1,1,1,1,1,1,1,2,2,2,3,3,3}
K=15.
15th Element is 3.

TEST CASE #2:
X1={1,2,3,4,1,2,3,4,1,2,3,4,1,2,3,4}
X2={1,2,1,2,1,2,1,2,1,2,1,2,1,2,1,2}
X3={1,1,1,1,1,1,1,1,1,1,1,1,1}
K=15
B cans 24 times 1. So the 15th element will be 1.
"""

def get_array(arr, l):
    d = []
    for i in range(l):
        d.append(arr[i])
    return d


def find_result(size, arr, key):
    array = {}
    for i in range(10):
        if 2 * i == 0:
            dic_key = 'X' + str(i+1)
            new_arr = get_array(arr, size)
            if len(new_arr) <= 0:
                return array
            array[dic_key] = new_arr * size * (i+1)
        else:
            dic_key = 'X' + str(i+1)
            new_arr = get_array(arr, (size // (2 * i)))
            if len(new_arr) <= 0:
                return array
            array[dic_key] = new_arr * size * (i+1)

    return array

if __name__ == "__main__":
    T = int(input())
    for _ in range(T):
        size = int(input())
        array = list(map(int, input().split()))
        search = int(input())
        d = []
        response = []
        if size != 0:
            res = find_result(size, array, search)
            for k,v in res.items():
                d = d + v
            ar = sorted(d)
            response.append(ar[search - 1])
        for res in response:
            print(res)