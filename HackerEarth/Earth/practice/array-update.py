"""   Fredo and Array Update
Fredo is assigned a new task today. He is given an array A containing N integers. His task is to update all elements of array to some minimum value x , that is, A[i]=x; 1<=i<=N ;  such that sum of this new array is strictly greater than the sum of the initial array. Note that x should be as minimum as possible such that sum of the new array is greater than the sum of the initial array.

Input Format:
First line of input consists of an integer N denoting the number of elements in the array A.
Second line consists of N space separated integers denoting the array elements.

Output Format:
The only line of output consists of the value of x.

Input Constraints:
1 <= N <= 10^5
1 <= A <= 1000

SAMPLE INPUT 
5
1 2 3 4 5
SAMPLE OUTPUT 
4

Explanation
Initial sum of array = 1+2+3+4+5
When we update all elements to 4, sum of array = 4+4+4+4+4 = 20  which is greater than 15.
Note that if we had updated the array elements to 3, sum=15,  which is not greater than 15. So, 4 is the minimum value to which array elements need to be updated.
"""
import datetime
# n, arr = int(input()), list(set(sorted(list(map(int, input().split())))))
n = 5
# arr = sorted([1, 6, 2, 3, 1, 2, 3, 6, 5])
arr = sorted([1, 5, 6, 1, 1, ])

l = len(arr)
s = sum(arr)
print(arr, '\t', s, l )
arr = list(set(arr))
print(arr)
start = datetime.datetime.now()
j = [arr[i+1] if l>1 else arr[i] for i in range(len(arr) - 1, -1, -1) if (arr[i] * l <= s) ]
print(j[0])
end = datetime.datetime.now()
print(end-start)
start1 = datetime.datetime.now()
for i in range(len(arr) - 1, -1, -1):
    print(arr[i] * l)
    if arr[i] * l <= s:
        print('a ', arr[i+1] if l>1 else arr[i])
        break
    else:
        print('e ', arr[i])
end1 = datetime.datetime.now()
print(end1-start1)