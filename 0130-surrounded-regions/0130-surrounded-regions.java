// Time: O(m * n)
// Space: O(m * n)

class Solution {
    int m, n;

    public void DFS(char[][] board, int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }

        board[i][j] = '#';

        DFS(board, i + 1, j);
        DFS(board, i - 1, j);
        DFS(board, i, j + 1);
        DFS(board, i, j - 1);
    }

    public void solve(char[][] board) {
        m = board.length;
        n = board[0].length;

        // Start DFS from top row, down row, left col, right col -> make replace O and its neighbour 0 by # 

        // Top and Bottom Row
        for(int col = 0; col < n; col++) {

            int topRow = 0;
            DFS(board, topRow, col);

            int bottomRow = m - 1;
            DFS(board, bottomRow, col);
        }

        // Left and Right Column
        for(int row = 0; row < m; row++) {

            // Left Column
            int leftCol = 0;
            DFS(board, row, leftCol);

            // Right Column
            int rightCol = n - 1;
            DFS(board, row, rightCol);
        }

        // Replace remain O by X and # by O 
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(board[i][j] == '#') {
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}