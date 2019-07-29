''' Read input from STDIN. Print your output to STDOUT '''
    #Use input() to read input from STDIN and use print to write your output to STDOUT

def main():
    testC = int(input())
    res = []
    for i in range(testC):
        all_vill_hero = int(input())
        villian = sorted(list(map(int, input().split())))
        hero = sorted(list(map(int, input().split())))
        d = [True if villian[i] < hero[i] else False for i in range(len(villian))]
        c = all(d)
        res.append(c)
    for r in res:
        if r:
            print('WIN')
        else:
            print('LOSE')
# Write code here 

main()

