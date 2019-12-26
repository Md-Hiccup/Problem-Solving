"""
Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome. 
A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
EXAMPLE

Input: Tact Coa
Output: True (permutations: "taco cat", "atco cta", etc.)

Hints: 
#106    :   You do not have to-and should not-generate all permutations. This would be very inefficient
#121    :   What characteristics would a string that is a permutation of a palindrome have?
#134    :   Have you tried a hash table? You should be able to get this down to 0( N) time.
#136    :   Can you reduce the space usage by using a bit vector?
"""

# This algorithm takes O ( N) time, where N is the length of the string.
class Solution_1:
    def is_permutation_of_pallindrome(self, phrase):
        table = self.build_char_frequency_table(phrase)
        return self.check_max_one_odd(table)

    def check_max_one_odd(self, table):
        found_odd = False
        for count in table:
            if count % 2 == 1:
                if found_odd:
                    return False
                found_odd = True
        return True

    def get_char_number(self, c):
        a = ord('a')
        z = ord('z')
        val = ord(c)
        if a <= val and val <= z:
            return val - a
        return -1

    def build_char_frequency_table(self, phrase):
        table = [0] * (ord('z') - ord('a') + 1)
        for char in phrase:
            x = self.get_char_number(char)
            if x != -1:
                table[x] += 1
        return table

# This algorithm will take O(n) times
class Solution_2:
    def is_permutation_of_pallindrome(self, phrase):
        count_odd = 0
        table = [0] * (ord('z') - ord('a') + 1)
        for c in phrase:
            x = self.get_char_number(c)
            if x != -1:
                table[x] += 1
                if table[x] % 2 == 1:
                    count_odd += 1
                else:
                    count_odd -= 1

        return count_odd  <= 1

    def get_char_number(self, c):
        a = ord('a')
        z = ord('z')
        val = ord(c)
        if a <= val and val <= z:
            return val - a
        return -1

# Solution 3
class Solution_3:
    def is_permutation_of_pallindrome(self, phrase):
        bit_vector = self.create_bit_vector(phrase)
        return bit_vector == 0 or self.check_exactly_one_bit_set(bit_vector)

    def get_char_number(self, c):
        a = ord('a')
        z = ord('z')
        val = ord(c)
        if a <= val and val <= z:
            return val - a
        return - 1
        
    def create_bit_vector(self, phrase):
        bit_vector = 0
        for c in phrase:
            x = self.get_char_number(c)
            bit_vector = self.toggle(bit_vector, x)
        return bit_vector

    def toggle(self, bit_vector, index):
        if index < 0:
            return bit_vector

        mask = 1 << index
        if (bit_vector & mask) == 0:
            bit_vector |= mask
        else:
            bit_vector &= not mask
        
        return bit_vector

    
    def check_exactly_one_bit_set(self, bit_vector):
        return (bit_vector & (bit_vector - 1)) == 0
        


if __name__ == "__main__":
    sentence = 'liril'
    # sentence = 'detartrated'
    # sentence = 'taco cat'
    
    # Solution 1
    sol_1 = Solution_1()
    sol1 = sol_1.is_permutation_of_pallindrome(sentence)
    print(f'Solution 1: {sol1}')

    # Solution 2
    sol_2 = Solution_2()
    sol2 = sol_2.is_permutation_of_pallindrome(sentence)
    print(f'Solution 2: {sol2}')

        # Solution 3
    sol_3 = Solution_3()
    sol3 = sol_3.is_permutation_of_pallindrome(sentence)
    print(f'Solution 3: {sol3}')