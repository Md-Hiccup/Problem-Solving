"""
5
--------e--------
------e-d-e------
----e-d-c-d-e----
--e-d-c-b-c-d-e--
e-d-c-b-a-b-c-d-e
--e-d-c-b-c-d-e--
----e-d-c-d-e----
------e-d-e------
--------e--------
"""

# def print_rangoli(size):
#     # your code goes here
#     # 5 = 5*4-3 ;   10 = 10*4-3
#     col = size*4-3
#     rev_string = []
#     ca = []
#     ca_to_ac = []
#     char_arr = []
#     for i in range(size-1,-1,-1):
#         char = chr(97+i)
#         char_arr = ca + list(char) + ca_to_ac
#         ca.append(char)
#         ca_to_ac = ca.copy()
#         ca_to_ac.reverse()
#         string = '-'.join(char_arr)
#         print(string.center(col,'-'))
#         rev_string.append(string)
        
#     for j in range(len(rev_string)-2, -1, -1):
#         print(rev_string[j].center(col, '-'))


# if __name__ == '__main__':
#     n = int(input())
#     print_rangoli(n)

import string
alpha = string.ascii_lowercase

n = int(input())
L = []
for i in range(n):
    s = "-".join(alpha[i:n])
    L.append((s[::-1] + s[1:]).center(4 * n - 3, "-"))

print('\n'.join(L[:0:-1]+L))