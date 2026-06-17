// Time Complexity = O(n! × n)
// Space Complexity: O(n²)


class Solution {
    
    List<List<String>> result = new ArrayList<>();

    public boolean isPossible(char[][] board, int n, int row, int col) {
        
        // Horizontal -> Row
        for(int i = 0; i < row; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // Vertical -> Col
        for(int j = 0; j < col; j++) {
            if(board[row][j] == 'Q') {
                return false;
            }
        }

        // Left Diagonal
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        // Right Diagonal
        for(int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public void solve(char[][] board, int n, int row) {
        if(row == n) {

            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                temp.add(new String(board[i]));
            }

            result.add(temp);
            return;
        }

        for(int col = 0; col < n; col++) {
            
            if(isPossible(board, n, row, col)) {
                board[row][col] = 'Q';

                solve(board, n, row + 1);

                board[row][col] = '.';
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for(char[] row : board){
            Arrays.fill(row, '.');
        }
        
        solve(board, n, 0);

        return result;
    }
}