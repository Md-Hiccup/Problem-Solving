"""
PROBLEM STATEMENT Points: 30
Given a chess board having  cells, you need to place N Knight on the board in such a way that no knight attacks any other knight.

Input:
The only line of input consists of a single integer denoting N.

Output:
If it is possible to place all the N knights in such a way that no knight attacks another knight, then print N lines having N integers. The integer in  line and  column will denote the cell  of the board and should be 1 if a knight is placed at  otherwise 0. If there are more than way of placing knights print any of them. If it is not possible to place all N knights in the desired way, then print "Not possible" (without quotes).

Constraints:
1 <= N <= 10

SAMPLE INPUT 
4
SAMPLE OUTPUT 
0  59  38  33  30  17   8  63
37  34  31  60   9  62  29  16
58   1  36  39  32  27  18   7
35  48  41  26  61  10  15  28
42  57   2  49  40  23   6  19
47  50  45  54  25  20  11  14
56  43  52   3  22  13  24   5
51  46  55  44  53   4  21  12
"""

def printSol(board):
    for i in range(N):
        for j in range(N):
            print(board[i][j], end=" ")
        print()

def isSafe(row, col, board):
    return (row >=0 and row < N and col >= 0 and col < N and board[row][col] == -1)

def solveKT():
    sol = [[-1 for i in range(N)] for j in range(N)]
    # for i in range(N):
    #     for j in range(N):
    #         sol[i][j] = -1
    
    xMove = [2, 1, -1, -2, -2, -1, 1, 2]
    yMove = [1, 2, 2, 1, -1, -2, -2, -1]

    sol[0][0] = 0

    if solveKTUtil(0, 0, 1, sol, xMove, yMove) == False:
        print('Solution does not exist')
        return False

    else:
        printSol(sol)

def solveKTUtil(x, y, movei, sol, xMove, yMove):
    if movei == N * N:
        return True
    
    for k in range(N):
        next_x = x + xMove[k]
        next_y = y + yMove[k]
        if isSafe(next_x, next_y, sol):
            sol[next_x][next_y] = movei
            if solveKTUtil(next_x, next_y, movei + 1, sol, xMove, yMove):
                return True
            else:
                sol[next_x][next_y] = -1
    
    return False


if __name__ == '__main__':
    N = 8
    solveKT()

