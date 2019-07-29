"""
Sample Input
1 2
3 4

Sample Output
(1, 3) (1, 4) (2, 3) (2, 4)
"""

from itertools import product

def cartesian_product(x, y):
    # Way 1
    print(*product(x, y))
    
    # Way 2
    res1 = [(i, j) for i in x for j in y]
    print(*res1)


if __name__ == '__main__':
    a = list(map(int, input().split(' ')))
    b = list(map(int, input().split(' ')))
    cartesian_product(a,b)
