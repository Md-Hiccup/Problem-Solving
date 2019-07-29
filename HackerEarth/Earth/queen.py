"""
PROBLEM STATEMENT Points: 30
Given a chess board having  cells, you need to place N queens on the board in such a way that no queen attacks any other queen.

Input:
The only line of input consists of a single integer denoting N.

Output:
If it is possible to place all the N queens in such a way that no queen attacks another queen, then print N lines having N integers. The integer in  line and  column will denote the cell  of the board and should be 1 if a queen is placed at  otherwise 0. If there are more than way of placing queens print any of them. If it is not possible to place all N queens in the desired way, then print "Not possible" (without quotes).

Constraints:
1 <= N <= 10

SAMPLE INPUT 
4
SAMPLE OUTPUT 
0 1 0 0 
0 0 0 1 
1 0 0 0 
0 0 1 0 
"""
# Print Solution
def printSol(board):
    for i in range(N):
        for j in range(N):
            print(board[i][j], end=" ")
        print()

def isSafe(board, row, col):
    
    # Check left side of the col
    for i in range(col):
        if board[row][i] == 1:
            return False

    # Check left side upper diagonal
    for i,j in zip(range(row, -1, -1), range(col, -1, -1)):
        if board[i][j] == 1:
            return False

    # Check left side lower diagonal
    for i, j in zip(range(row, N, 1), range(col, -1, -1)):
        if board[i][j] == 1:
            return False
    
    return True


def solveNQUtil(board, col):

    if col >= N:
        return True

    for i in range(N):
        if isSafe(board, i, col):
            board[i][col] = 1
        
            if solveNQUtil(board, col+1) == True:
                return True
        
            board[i][col] = 0

    return False

if __name__ == "__main__":
    inp = int(input("Enter the grid size: "))
    
    #   One Way 
    import numpy as np
    board = np.zeros((inp, inp), dtype=int)

    #   Second Way
    # board = []
    # for i in range(inp):
    #     second = []
    #     for j in range(inp):
    #         second.append(0)
    #     board.append(second)
    # print(board)

    N = inp
    if solveNQUtil(board, 0) == False:
        print("Solution does not exist")
        exit()
    printSol(board)
