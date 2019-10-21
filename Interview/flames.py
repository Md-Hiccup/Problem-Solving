# ANSR Source Flames


def getResult(boy, girl):
    # temp = boy[:] if len(boy) > len(girl) else girl[:]
    # compare = girl[:] if temp == boy[:] else boy[:]
    temp = girl[:]
    compare = boy[:]

    for b in temp:
        if b in compare:
            girl.remove(b)
            boy.remove(b)
            temp = girl[:]
            compare = boy[:]

    total = len(boy) + len(girl)

    flames = ['F', 'L', 'A', 'M', 'E', 'S']

    while(len(flames) != 1):
        try:
            del flames[total-1]
        except IndexError as e:
            new_ls = flames * len(flames) * total
            getChar = new_ls[total-1]
            index = flames.index(getChar)
            flames.remove(getChar)
            flames = flames[index:] + flames[:index]

    dict_flames = {'F': 'Friend', 'L': 'Love', 'A': 'Affair',
                   'M': 'Marriage', 'E': 'Enemy', 'S': 'Sister'}
    return dict_flames[flames[0]]


def getName():
    boy = list(input('Enter boy Name\n').strip())
    girl = list(input('Enter girl Name\n').strip())
    return (boy, girl)


def start():
    boy, girl = getName()
    res = getResult(boy, girl)
    print('Your relation with your mate is', res, '\n')
    one_more_time = input('Want to play it again(n for exit):  ')
    return one_more_time


print('Welcome to FLAMES game\n')
s = start()
while(s.lower() != 'n'):
    s = start()
