"""
Sample Input:   alpha romeo
Sample Output:  Alpha Romeo

Input:      hello   world  lol
Output:     Hello   World  Lol
"""
import re
def solve(s):
    a = re.split('\s', s)
    d = [x[0].upper() + x[1:] if len(x) else  x for x in a]
    return ' '.join(d)


if __name__ == '__main__':
    s = input()
    result = solve(s)
    print(result)