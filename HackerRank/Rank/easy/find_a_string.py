"""
Sample Input
AbBaAbBaAbBa
bBa

Sample Output
3
"""
class StringManipulation:
    def count_substring(string, substring):
        j = 0
        for i in range(len(string)):        # range(len(string)-len(substring)+1)
            if string[i:i+len(substring)] == substring:
                j = j + 1
        return j

if __name__ == "__main__":
    s = 'AbBaAbBaAbBa'
    ss = 'Ab'
    # s = 'This the first test.'
    # ss = 'test'
    # s = 'ABCDCDC'
    # ss = 'CDC'
    times = StringManipulation.count_substring(s, ss)
    print(times)
    