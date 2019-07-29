"""     

******* Last Occurrence *******

You have been given an array of size N consisting of integers. In addition you have been given an element M you need to find and print the index of the last occurrence of this element M in the array if it exists in it, otherwise print -1. Consider this array to be 1 indexed.

Input Format:

The first line consists of 2 integers N and M denoting the size of the array and the element to be searched for in the array respectively . The next line contains N space separated integers denoting the elements of of the array.

Output Format

Print a single integer denoting the index of the last occurrence of integer M in the array if it exists, otherwise print -1.

Constraints
1 <= N <= 10^5
1 <= A[i] <= 10^9
1 <= M <= 10^9


SAMPLE INPUT

5 1
1 2 3 4 1

SAMPLE OUTPUT

5
"""

#   Test 1
l1 = "5 1"
l2 = "1 2 3 4 1"

#   Test 2
l1 = "100 2"
l2 = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100"

n, m = list(map(int, l1.split()))
arr = list(map(int, l2.split()))
# n, m = list(map(int, input().split()))
# arr = list(map(int, input().split()))

index = 1
count = 0
for i in range(len(arr)-1, -1, -1):
    if i < 0:
        index = -1
    elif arr[i] == m:
        print(arr[i], m, i)
        index += i
        print(index)
        break
print(index)