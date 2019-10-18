"""
There is a list of same value with different format
inp = [ 'code', 'deco', 'ecod', 'for', 'fore', 'age', 'aage']
out = [ 'code', 'for', 'fore', 'age']

Here 'code', 'deco', 'ecod' are same so take first 'code'
'for' and 'fore' are different so take both 'for' and 'fore'
'age' and 'aage' letter are same so take first 'age;
"""

inp = ['code', 'deco', 'ecod', 'for', 'rof', 'fore', 'age', 'aage']

is_same = 0
a = []
b = inp[:]
for i in range(len(inp)):
    old = set(inp[i])
    for j in range((i + 1), len(inp)):
        next = set(inp[j])
        if next == old:
            b.remove(inp[j])
            break

print(b)