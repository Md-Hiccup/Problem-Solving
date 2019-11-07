"""
1. Memorization
2. Tabulation 
"""
from datetime import datetime

#Todo: Recursion Method
def rec_fibonacci(n):
    if n <= 1:
        return n
    return rec_fibonacci(n-1) + rec_fibonacci(n-2)

#Todo: Memorization Method
def mem_fibonacci(n, lookup):
    if n == 0 or n == 1:
        lookup[n] = n
    
    if lookup[n] is None:
        lookup[n] = mem_fibonacci(n - 1, lookup) + mem_fibonacci(n - 2, lookup)
        
    return lookup[n]


#Todo: Tabulation Method
def tab_fibonacci(n):
    lookup = [None]*101
    lookup[0] = 0
    lookup[1] = 1
    for i in range(2, n+1):
        lookup[i] = lookup[i - 1] + lookup[i - 2]
    return lookup[n]


if __name__ == "__main__":
    numb = int(input())

    start = datetime.now()
    res = rec_fibonacci(numb)
    end = datetime.now()
    print('Recursion method: {} is {}'.format(numb, res))
    print('Total Time: ', end-start)


    start = datetime.now()    
    lookup = [None] * 100
    res = mem_fibonacci(numb, lookup)
    end = datetime.now()
    print('Memorization method: {} is {}'.format(numb, res))
    print('Total Time: ', end-start)


    start = datetime.now()    
    res = tab_fibonacci(numb)
    end = datetime.now()
    print('Tabulation method: {} is {}'.format(numb, res))
    print('Total Time: ', end-start)

#*************************