def gcd1(a, b):
    if b == 0:
        return a
    else:
        return gcd1(b, a % b)

def gcd2(a, b):
    while b != 0:
        a, b = b, a % b
    return a

def gcd3(a, b):
    while a != b:
        if a > b:
            a = a - b
        else:
            b = b - a
    return a
        
def lcm(a, b):
    numer = a * b
    deno = gcd1(a, b)
    return numer//deno

# def gcd(a, b, c):
#     pass

# def lcm(a, b, c):
#     numer = a * b * c
#     deno = gcd(a,b,c)

if __name__ == '__main__':
    a = 21
    b = 6

    gcd_1 = gcd1(a, b)
    print(gcd_1)
    
    gcd_2 = gcd2(a, b)
    print(gcd_2)

    gcd_3 = gcd3(a, b)
    print(gcd_3)

    lcm = lcm(a, b)
    print(lcm)