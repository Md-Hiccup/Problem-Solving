"""
7 21
---------.|.---------
------.|..|..|.------
---.|..|..|..|..|.---
-------WELCOME-------
---.|..|..|..|..|.---
------.|..|..|.------
---------.|.---------
"""
# Enter your code here. Read input from STDIN. Print output to STDOUT
inp = list(input().split(' '))
m = int(inp[0])
n = int(inp[1])
sym = '.|.'
wel = 'WELCOME'
d = 1
for i in range(0,m//2):
    symbol = sym*d
    a = symbol.center(n, '-')
    print(a)
    d = d+2

print(wel.center(n, '-'))

b = d-2
for i in range(0,m//2):
    symbol = sym*b
    a = symbol.center(n, '-')
    print(a)
    b = b-2