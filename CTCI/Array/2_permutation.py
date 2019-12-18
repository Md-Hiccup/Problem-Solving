"""
Check Permutation: Given two strings, write a method to decide if one is a permutation of the other

Hints: 
#1      :   Describe what it means for two strings to be permutations of each other. Now, look at
that definition you provided. Can you check the strings against that definition? 
#84     :   There is one solution that is 0( N log N) time. Another solution uses some space, but is O(N) time.
#122    :   Could a hash table be useful?
#131    :   Two strings that are permutations should have the same characters, but in different
orders. Can you make the orders the same
"""

""" Ask to Clarify Question
1.  Case Sensitive: is "God" a permutation of "dog"?
2.  White Spaces  : "god    " is different from "dog". 
"""

""" Observation
1. Strings of different lengths cannot be permutations of each other.
"""

""" Solutions
1.  Sort the Strings:   
    If two strings are permutations, then we know they have the same characters, but in different orders. 
    There­fore, sorting the strings will put the characters from two permutations in the same order. 
    We just need to compare the sorted versions of the strings.
2.  Check if the two strings have identical characters counts:
    We can also use the definition of a permutation-two words with the same character counts-to imple­ment 
    this algorithm. We simply iterate through this code, counting how many times each character appears.
    Then, afterwards, we compare the two arrays.
"""

# Solution #1: Sort the strings.
def string_sort(s):
    ls = sorted(list(s))
    return ls

def permutation_1(s, t):
    if len(s) != len(t):
        return False
    return string_sort(s) == string_sort(t)
# End

# Solution #2: Check if the two strings have identical character counts.
def permutation_2(s, t):
    if len(s) != len(t):
        return False

    # letters = [0]*128   # [0 0 0 ... 0]
    # print(letters)
    
    # dict.fromkeys(['a', 'b', 'c'], 0)     // { 'a': 0, 'b': 0, 'c': 0}
    letters = dict.fromkeys(list(s),0)

    for i in s:
        letters[i] += 1
    
    for i in t:
        if i in letters:
            letters[i] -= 1
            if letters[i] < 0:
                return False
        else:
            return False
    return True
# End


if __name__ == "__main__":
    string_s = "ogd1"
    string_t = "dgo1"

    # 1
    is_perm = permutation_1(string_s, string_t)
    print("Solution 1: ", is_perm)

    # 2
    is_perm1 = permutation_2(string_s, string_t)
    print("Solution 2: ", is_perm1)
