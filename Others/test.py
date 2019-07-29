data = [(1, 'a', '!'), (2, 'b', '@'), (3, 'c', '#'), (4, 'd', '$')]

def codeList(x):
    d = {}
    d['type_id'] = x[0]
    d['campaign_id'] = x[1]
    d['volume'] = x[2]
    return d
old_data = list(map(codeList, data))
res = {}
res['result'] = old_data
print(res)