// Time Complexity:  O(9^m)
// Space Complexity: O(m)
// m is the number of empty cells in the Sudoku board.

class Solution {
    public boolean isPossible(char[][] board, int row, int col, char digit) {
        // Horizontal
        for(int j = 0; j < 9; j++) {
            if(board[row][j] == digit) {
                return false;
            }
        }

        //Vertical
         for(int i = 0; i < 9; i++) {
            if(board[i][col] == digit) {
                return false;
            }
        }

        // 3x3 Grid
        int newRow = (row / 3) * 3;
        int newCol = (col / 3) * 3;

        for(int i = newRow; i <= newRow + 2; i++) {
            for(int j = newCol; j <= newCol + 2; j++) {
                if(board[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solve(char[][] board, int row, int col) {
        if(row == 9) {
            return true;
        }

        int nextRow = row, nextCol = col + 1;
        if(nextCol == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if(board[row][col] != '.') {
            return solve(board, nextRow, nextCol);
        }

        for(char digit = '1'; digit <= '9'; digit++) {

            if(isPossible(board, row, col, digit)) {
                board[row][col] = digit;

                if(solve(board, nextRow, nextCol)) {
                    return true;
                }

                board[row][col] = '.';
            }
        }

        return false;
    }

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }
}