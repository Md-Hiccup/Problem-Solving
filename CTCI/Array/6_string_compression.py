"""
String Compression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).

Hints:
#92     :   Do the easy thing first. Compress the string, then compare the lengths.
#110    :   Be careful that you aren't repeatedly concatenating strings together. This can be very
inefficient
"""

class Solution1():
    def compress_bad(self, string):
        compressed_string = ""
        count_consecutive = 0
        for i in range(len(string)):
            count_consecutive += 1

            if i + 1 >= len(string) or string[i] != string[i + 1]:
                compressed_string += "" + string[i] + str(count_consecutive)
                count_consecutive = 0
            
        return compressed_string if len(compressed_string) < len(string) else string


class Solution2():
    def compress(self, string):
        # * Check final length and return input string if it would be longer. *
        final_length = self.count_compression(string)
        if final_length >= len(string):
            return string

        compressed = ''
        count_consecutive = 0
        for i in range(len(string)):
            count_consecutive += 1
            
            if i + 1 >= len(string) or string[i] != string[i + 1]:
                compressed += string[i]
                compressed += str(count_consecutive)
                count_consecutive = 0
            
        return compressed

    def count_compression(self, string):
        compressed_length = 0
        count_consecutive = 0
        for i in range(len(string)):
            count_consecutive += 1

            # If next character is different than current, increase the length
            if i + 1 >= len(string) or string[i] != string[i + 1]:
                compressed_length += 1 + len(string)
                count_consecutive = 0

        return compressed_length

if __name__ == "__main__":
    string = 'aaabbbbcccccccccaa'

    sol1 = Solution1()
    sol_1 = sol1.compress_bad(string)
    print('Solution 1: ', sol_1)

    sol2 = Solution2()
    sol_2 = sol2.compress(string)
    print('Solution 2: ', sol_1)
