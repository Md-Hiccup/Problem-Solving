"""
Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place?

Hints: 
#51     :   Try thinking about it layer by layer. Can you rotate a specific layer?
#100    :   Rotating a specific layer would just mean swapping the values in four arrays. If you were
asked to swap the values in two arrays, could you do this? Can you then extend it to four
arrays?
"""

def rotate(matrix):
    if len(matrix) == 0 or len(matrix[0]) != len(matrix):
        return False

    n = len(matrix)
    for layer in range(n // 2):
        first = layer
        last = n - 1 - layer
        for i in range(last):
            offset = i - first
            if offset >=0 :
                top = matrix[first][i]
                matrix[first][i] = matrix[last - offset][first]
                matrix[last - offset][first] = matrix[last][last - offset]
                matrix[last][last - offset] = matrix[i][last]
                matrix[i][last] = top
    
    return matrix


def print_matrix(m):
    for i in m:
        print(i)


if __name__ == "__main__":
    mat = [
        [7, 4, 9, 3],
        [5, 8, 6, 2],
        [1, 10, 14, 15],
        [20, 25, 30, 35]
    ]

    m = rotate(mat)
    print_matrix(m)