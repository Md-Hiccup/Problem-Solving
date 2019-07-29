"""
Input:
10
161 182 161 154 176 170 167 171 170 174

Output:
169.375
"""


def average(array):
    # your code goes here
    total = sum(set(array))
    l = len(set(array))
    return "%.3f"%(total/l)

if __name__ == '__main__':
    # n = int(input())
    # arr = list(map(int, input().split()))
    n = 10
    arr = [161, 182, 161, 154, 176, 170, 167, 171, 170, 174]
    result = average(arr)
    print(result)