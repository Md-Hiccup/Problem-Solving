"""
ginortS or Sorting
Your task is to sort the string S in the following manner:

-   All sorted lowercase letters are ahead of uppercase letters.
-   All sorted uppercase letters are ahead of digits.
-   All sorted odd digits are ahead of sorted even digits.


Sample Input:       Sorting1234
Sample Output:      ginortS1324

Input (stdin):      1qaz2wsx3edc4rfv5tgb6yhn7ujm8ik9ol0pQWERTYUIOPASDFGHJKLZXCVBNM
Expected Output:    abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1357902468

Input (stdin):      qwerty123456789dfghj123456789QWERTYUIOPASDFGHJKLZXCVBNM0123456789
Expected Output:    defghjqrtwyABCDEFGHIJKLMNOPQRSTUVWXYZ1113335557779990222444666888
"""

# Enter your code here. Read input from STDIN. Print output to STDOUT
def sort_digit(arr):
    dig = list(map(int, arr))
    odd = sorted([i for i in dig if i % 2])
    even = sorted([i for i in dig if i % 2 == 0])
    digg = list(map(str, sorted(odd+even, key=lambda x: x % 2 != 1)))
    return digg

def do_sort(string):
    low = sorted([i for i in string if i.islower()])
    upp = sorted([i for i in string if i.isupper()])
    dig = sort_digit([i for i in string if i.isdigit()])
    print(''.join(list(low+upp+dig)))

S = list(map(str, input()))
d = sorted(S, key=do_sort(S))


