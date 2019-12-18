""" Question
Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
Hints: 
#44     =   Try a Hash Table.
#117    =   Could a bit vector be useful?
#132    =   Can you solve it in O(N log N) time? What might a solution like that look like?
"""

""" Ask to Clarify Question
1.  First, Let know, Is string is ASCII string or Unicode string.   (Assume String is ASCII)
"""

""" Solution
1.  One solution is to create an array of boolean values, where the flag at index i indicates whether character
i in the alphabet is contained in the string. The second time you see this character you can immediately
return false.
2.  We can also immediately return false if the string length exceeds the number of unique characters in the
alphabet. After all, you can't form a string of 280 unique characters out of a 128-character alphabet.

**
It's also okay to assume 256 characters. This would be the case in extended ASCII. You should
clarify your assumptions with your interviewer.
**
"""

def is_unique_chars(string):
    if len(string) > 128:
        return False
    
    char_set = [False] * 128
    
    for i in string:
        val = ord(i)
        if char_set[val]:
            return False
        char_set[val] = True
    
    return True    

if __name__ == '__main__':
    string = "abcdefghia"
    isUnique = is_unique_chars(string)
    print(isUnique)

"""
Note:
If we can't use additional data structures, we can do the following:
1. Compare every character of the string to every other character of the string. This will take 0( n 2 ) time
and 0(1) space.
2. If we are allowed to modify the input string, we could sort the string in O(n log(n)) time and then
linearly check the string for neighboring characters that are identical. Careful, though: many sorting
algorithms take up extra space
"""