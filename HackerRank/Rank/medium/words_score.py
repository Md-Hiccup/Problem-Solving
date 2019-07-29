"""
Problem:    If word contain even no. of vowel than count = 2 else count = 1. Find sum of vowel count.
Sample Input:
2
hacker rank

Sample Output:
3
"""

def is_vowel(letter):
    return letter in ['a', 'e', 'i', 'o', 'u', 'y']

#   Start Debugging the code here
def score_words(words):
    score = 0
    for word in words:
        num_vowels = 0
        for letter in word:
            if is_vowel(letter):
                num_vowels += 1
        if num_vowels % 2 == 0:
            score += 2
        else:
            score += 1
    return score
#   End Debugging

n = int(input())
words = input().split()
print(score_words(words))