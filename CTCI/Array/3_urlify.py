
"""
URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
EXAMPLE

Input: "Mr John Smith     ", 13
Output: "Mr%20John%20Smith"

Hints:
#53     =   It's often easiest to modify strings by going from the end of the string to the beginning 
#118    =   You might find you need to know the number of spaces. Can you just count them?
"""


def replaceSpaces(string, trueLength):
    string = list(string)
    space_count = 0
    index = 0
    for i in range(trueLength):
        if string[i] == ' ':
            space_count += 1
    
    index = trueLength + space_count * 2
    if trueLength < len(string):
        string[trueLength] = '\0'
    
    for i in range(trueLength - 1, -1, -1):
        if string[i] == ' ':
            string[index - 1] = '0'
            string[index - 2] = '2'
            string[index - 3] = '%'
            index -= 3
        else:
            string[index - 1] = string[i]
            index -= 1
    return ''.join(string)

if __name__ == "__main__":
    string = "Mr John Smith      "
    length = 13
    
    # out = "%20".join(inp.split())

    new_string = replaceSpaces(string, length)
    print(new_string)