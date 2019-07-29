"""
Little Shino and Common factors
Max. Marks: 100
Little Shino loves maths. Today her teacher gave her two integers. Shino is now wondering how many integers can divide both the numbers. She is busy with her assignments. Help her to solve the problem.

Input:
First line of the input file contains two integers, a and b.

Output:
Print the number of common factors of a and b.

Constraints:
1 <= a,b <= 10^12

SAMPLE INPUT 
10 15
SAMPLE OUTPUT 
2
Explanation
The common factors of 10 and 15 are 1 and 5.
"""

def chkCommonFactor(num):
    arr = set()
    for i in range(1, num+1):
        if num % i == 0:
            arr.add(i)
    return arr

a, b = list(map(int, input().split()))
# a , b = 10, 15
aa = chkCommonFactor(a)
bb = chkCommonFactor(b)
print(aa, bb)
print(len(aa & bb))

# all_no = list(map(int, input().split()))
# count = 0
# ar = []
# for _ in all_no:
    # ar.append(chkCommonFactor(_))
