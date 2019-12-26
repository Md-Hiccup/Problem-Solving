"""
One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
pale, ple   ->  true
pales, pale ->  true
pale, bale  ->  true
pale, bake  ->  false

Hints:
#23     :   Start with the easy thing. Can you check each of the conditions separately
#97     :   What is the relationship between the "insert character" option and the "remove char­acter" option? Do these need to be two separate checks?
#130    :   Can you do all three checks in a single pass?
"""

"""
Replacement: Consider two strings, such as bale and pale, that are one replacement away. Yes, that
does mean that you could replace a character in bale to make pale. But more precisely, it means that
they are different only in one place.

Insertion: The strings apple and aple are one insertion away. This means that if you compared the
strings, they would be identical-except for a shift at some point in the strings.

Removal: The strings apple and aple are also one removal away, since removal is just the inverse of
insertion.
"""

class Solution1():
    def one_edit_away(self, first, second):
        if len(first) == len(second):
            return self.one_edit_replace(first, second)
        elif len(first) + 1 == len(second):
            return self.one_edit_insert(first, second)
        elif len(first) - 1 == len(second):
            return self.one_edit_insert(second, first)
    
        return False
    
    def one_edit_replace(self, s1, s2):
        found_difference = False
        for i in range(len(s1)):
            if s1[i] != s2[i]:
                if found_difference:
                    return False
                found_difference = True
        
        return True
    
    def one_edit_insert(self, s1, s2):
        index1 = 0
        index2 = 0
        while (index2 < len(s2) and index1 < len(s1)):
            if s1[index1] != s2[index2]:
                if index1 != index2:
                    return False
                index2 += 1
            else:
                index1 += 1
                index2 += 1
        
        return True

class Solution2():
    def one_edit_away(self, first, second):
        if abs(len(first) - len(second)) > 1:
            return False

        s1 = first if len(first) < len(second) else second
        s2 = second if len(first) < len(second) else first

        index1 = 0
        index2 = 0
        found_difference = 0

        while index1 < len(s1) and index2 < len(s2):
            if s1[index1] != s2[index2]:
                if found_difference:
                    return False
                
                found_difference = True

                if len(s1) == len(s2):
                    index1 += 1

            else:
                index1 += 1

            index2 += 1

        return True

if __name__ == "__main__":
    # False
    st1 = "appple"
    st2 = "aple"

    # True
    # st1 = "pale"
    # st2 = "palz"

    # Solution 1
    sol1 = Solution1()
    sol_1 = sol1.one_edit_away(st1, st2)
    assert sol1.one_edit_away('apple', 'aple') == True, 'Passed'
    print("Solution 1: ", sol_1)


    # Solution 2
    sol2 = Solution2()
    sol_2 = sol2.one_edit_away(st1, st2)
    print('Solution 2: ', sol_2)
