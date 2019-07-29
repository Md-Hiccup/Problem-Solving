"""
any():  
This expression returns True if any element of the iterable is true. 
If the iterable is empty, it will return False.

all():
This expression returns True if all of the elements of the iterable are true. If the iterable is empty, it will return True.

Prob: Print True if all the conditions of the problem statement are satisfied. Otherwise, print False
Sample Input
5
12 9 61 5 14

Sample Output
True
"""

# Enter your code here. Read input from STDIN. Print output to STDOUT
n, numb = int(input()), list(map(int, input().split()))
chk_any = all(list(map(lambda x: x > 0, numb)))
pallindromic_any = any(list(map(lambda x: list(str(x)) == list(reversed(str(x))), numb)))
print(chk_any and pallindromic_any)