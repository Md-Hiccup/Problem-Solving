"""
Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.

Hints:
#17     :   If you just cleared the rows and columns as you found Os, you'd likely wind up clearing
the whole matrix. Try finding the cells with zeros first before making any changes to the
matrix.
#74     :   Can you use O(N) additional space instead of O(N^2)? What information do you really
need from the list of cells that are zero?
#102    :   You probably need some data storage to maintain a list of the rows and columns that
need to be zeroed. Can you reduce the additional space usage to 0(1) by using the
matrix itself for data storage?
"""
import copy

class Solution1:
    def set_zero(self, matrix):
        row = [False] * len(matrix)
        col = [False] * len(matrix[0])

        #  Store the row and column index with value 0
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                if matrix[i][j] == 0:
                    row[i] = True
                    col[j] = True
        
        # Nullify rows
        for i in range(len(row)):
            if row[i]:
                self.nullifyRow(matrix, i)

        # Nullify columns
        for j in range(len(col)):
            if col[j]:
                self.nullifyColumn(matrix, j)
        return matrix

    def nullifyRow(self, matrix, row):
        for j in range(len(matrix[0])):
            matrix[row][j] = 0

    def nullifyColumn(self, matrix, col):
        for i in range(len(matrix)):
            matrix[i][col] = 0


class Solution2():
    def set_zero(self, matrix):
        row_has_zero = False
        col_has_zero = False

        # Check if first row has zero
        for j in range(len(matrix[0])):
            if matrix[0][j] == 0:
                row_has_zero = True
                break
        
        # Check if first column has zero
        for i in range(len(matrix)):
            if matrix[i][0] == 0:
                col_has_zero = True
                break
        
        # Check for zero in the rest of the array
        for i in range(1, len(matrix)):
            for j in range(1, len(matrix[0])):
                if matrix[i][j] == 0:
                    matrix[i][0] = 0
                    matrix[0][j] = 0
        

        # Nullify row based on values in first column
        for i in range(len(matrix)):
            if matrix[i][0] == 0:
                self.nullify_row(matrix, i)

        # Nullify column based on values in first row
        for j in range(len(matrix[0])):
            if matrix[0][j] == 0:
                self.nullify_col(matrix, j)

        # Nullify first row
        if row_has_zero:
            self.nullify_row(matrix, 0)

        if col_has_zero:
            self.nullify_col(matrix, 0)
    
        return matrix

    def nullify_row(self, matrix, row):
        for j in range(len(matrix[0])):
            matrix[row][j] = 0

    def nullify_col(self, matrix, col):
        for i in range(len(matrix)):
            matrix[i][col] = 0


def print_matrix(mat):
    for i in mat:
        print(i)
    print('\n')

if __name__ == "__main__":
    matrix = [
        [51, 12, 3, 4],
        [5, 16, 7, 38],
        [39, 10, 0, 12],
        [13, 14, 15, 16]
    ]

    # Solution 1
    print("Solution 1")
    # matrix_copy = matrix[:]
    matrix_copy = copy.deepcopy(matrix)

    s1 = Solution1()
    mat = s1.set_zero(matrix_copy)
    print_matrix(mat)


    # Solution 2
    print('Solution 2')
    matrix_copy_2 = copy.deepcopy(matrix)
    s2 = Solution2()
    mat = s2.set_zero(matrix_copy_2)
    print_matrix(mat)