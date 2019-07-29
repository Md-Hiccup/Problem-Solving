"""
Sample Input

17
Sample Output

    1     1     1     1
    2     2     2    10
    3     3     3    11
    4     4     4   100
    5     5     5   101
    6     6     6   110
    7     7     7   111
    8    10     8  1000
    9    11     9  1001
   10    12     A  1010
   11    13     B  1011
   12    14     C  1100
   13    15     D  1101
   14    16     E  1110
   15    17     F  1111
   16    20    10 10000
   17    21    11 10001 
"""

def print_formatted(number):
    for i in range(1, number+1):
        w = len(bin(number)[2:])
        b = bin(i)[2:]
        o = oct(i)[2:]
        h = hex(i)[2:]
        print(str(i).rjust(w), str(o).rjust(w), str(h.upper()).rjust(w), str(b).rjust(w))



if __name__ == "__main__":
    n = int(input())
    print_formatted(n)
