def decor(func):
    def wrap():
        print('$$$$$$$$$$')
        func()
        print('$$$$$$$$$$')
    return wrap

@decor
def sayhi():
    print('Hi')

sayhi()