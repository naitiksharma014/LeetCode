// Time: O(m * n * 4^L)  (L = word.length())
// Space: O(L) recursion stack

class Solution {
    int m, n;
    int[][] directions = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    
    public boolean solve(int i, int j, int idx, char[][] board, String word) {
        if(idx >= word.length()) {
            return true;
        }

        if(i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$';

        for(int[] direction: directions) {
            int new_i = i + direction[0];
            int new_j = j + direction[1];

            if(solve(new_i, new_j, idx + 1, board, word)){
                return true;
            }
        }

        board[i][j] = temp;

        return false;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0) && solve(i, j, 0, board, word)) {
                    return true;
                }
            }
        }

        return false;
    }
}