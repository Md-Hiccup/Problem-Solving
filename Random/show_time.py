""" NOT DONE TILL
Something to Watch
You’re given n shows, each with a fixed start time (s) and an end time (e). Each show is telecasted on a different channel. Find the total duration during which at least one show is being telecasted.
Constraints
1 <= t <= 10^3
1 <= n<= 10^4
1 <= e - s (in seconds) <= 24 * 60 * 60
Time format is a 24 hour clock with start of the day as 00:00:00 and end as 24:00:00.

Input Format
The first line contains a single integer t, denoting the number of test cases.
The first line of each test case contains a single integer n denoting the number of shows (and channels).
Following n lines contains the start s and end e for each show space separated.

Output Format
For each test case print the total duration.

Sample Input
10
3
07:00:00 09:30:00
09:00:00 10:30:00
11:00:00 11:30:00
1
00:00:00 24:00:00
1
20:30:00 21:00:00
1
00:00:00 23:59:59
1
00:00:01 23:59:59
2
12:00:00 13:00:00
14:00:00 21:00:00
3
12:00:00 24:00:00
14:00:00 22:00:00
16:00:00 20:00:00
8
18:30:00 21:30:00
07:00:00 23:00:00
14:30:00 22:00:00
01:30:00 11:30:00
07:30:00 13:00:00
22:30:00 23:30:00
17:30:00 18:00:00
01:00:00 02:30:00
4
01:00:00 02:00:00
03:00:00 04:00:00
04:00:00 12:00:00
15:00:00 24:00:00
5
13:00:00 24:00:00
00:00:00 08:00:00
14:00:00 24:00:00
08:00:00 14:00:00
00:00:00 13:00:00

Sample Output
04:00:00
24:00:00
00:30:00
23:59:59
23:59:58
08:00:00
12:00:00
22:30:00
19:00:00
24:00:00
"""
# from collections import namedtuple
# Time = namedtuple('Time', ('H', 'M', 'S'))
from datetime import datetime
from datetime import timedelta

def compare_dict(dc):
    tmp = []
    for k, v in dc.items():
        kd = time_convert(k)
        kv = time_convert(v)
        tmp.append(kd)
        tmp.append(kv)

    total_time = get_time_list(tmp)
    return total_time

def time_convert(tm):
    # tm:  '07:00:00'
    (h, m, s) = tuple(map(int, tm.split(':')))
    return (h, m, s)

def get_time_list(ls):
    total = ''
    if len(ls) > 2:
        total = time_diff(ls)
    else:
        total = get_diff(ls[0], ls[1])
        print('tt:', total)
    return total    

def sort_list(item):
    return item[0]

def time_diff(ls):
    print(ls)
    ls = sorted(ls, key=sort_list)
    print(ls)
    add_diff = []
    diff = 0
    start = ls[0]
    total = timedelta(hours=0, minutes=0, seconds=0)
    for i in range(1, len(ls) - 2, 2):
        if ls[i] < ls[i + 1]:
            end = ls[i]
            diff = get_diff(start, end)
            add_diff.append(diff)
            start = ls[i + 1]

    if i + 2 == len(ls) - 1:
        end = ls[-1]
        add_diff.append(get_diff(start, end))

    print(add_diff)

    for i in add_diff:
        tm = list(map(int, i.split(':')))
        total = total + timedelta(hours=tm[0], minutes=tm[1], seconds=tm[2])
    
    return str(total)

def get_diff(start, end):
    diff = str(timedelta(hours=end[0], minutes=end[1], seconds=end[2]) - timedelta(hours=start[0], minutes=start[1], seconds=start[2]))
    return diff


if __name__ == "__main__":
    # T = int(input())
    T = 1
    for _ in range(T):
        shows = int(input())
        # shows = 8
        total = []
        temp = {}
        for sh in range(shows):
            start_end = input().split(' ')
            if start_end[0] in temp and temp[start_end[0]] < start_end[1]:
                temp[start_end[0]] = start_end[1]
            else:
                temp[start_end[0]] = start_end[1]
        # temp = {
        #     '07:00:00': '09:30:00',
        #     '09:00:00': '10:30:00',
        #     '11:00:00': '11:30:00'
        # }
        print(temp)
        data = compare_dict(temp)
        print('Total Time: ', data)

""" 
13:00:00 24:00:00
00:00:00 08:00:00
14:00:00 24:00:00
08:00:00 14:00:00
00:00:00 13:00:00

12:00:00 24:00:00
14:00:00 22:00:00
16:00:00 20:00:00

18:30:00 21:30:00
07:00:00 23:00:00
14:30:00 22:00:00
01:30:00 11:30:00
07:30:00 13:00:00
22:30:00 23:30:00
17:30:00 18:00:00
01:00:00 02:30:00

07:00:00 09:30:00
09:00:00 10:30:00
11:00:00 11:30:00
"""