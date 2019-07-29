"""
Sample Input 0
3
odd 2       # 1 3
even 3      # 0 2 4 
odd 5       # 1 3 5 7 9

Sample Output 0
1
3
0
2
4
1
3
5
7
9

Explanation 0

"""

class EvenStream(object):
    def __init__(self):
        self.current = 0

    def get_next(self):
        to_return = self.current
        self.current += 2
        return to_return

class OddStream(object):
    def __init__(self):
        self.current = 1

    def get_next(self):
        to_return = self.current
        self.current += 2
        return to_return

# Start Debuggin the code Here
def print_from_stream(n, stream=None):
    if stream is None:
        stream = EvenStream()
    for _ in range(n):
        print(stream.get_next())
# End Debugging

queries = int(input())
for _ in range(queries):
    stream_name, n = input().split()
    n = int(n)
    if stream_name == "even":
        print_from_stream(n)
    else:
        print_from_stream(n, OddStream())