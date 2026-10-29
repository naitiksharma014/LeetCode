// Time Complexity: O(m * n * 4^L)
// Auxiliary Space Complexity: O(L) ; L = length of word.

class Solution {
    int m, n;

    public boolean solve(int i, int j, int idx, char[][] board, String word) {
        if(idx == word.length()) {
            return true;
        }

        if(i < 0 || i >= m || j < 0 || j >= n) {
            return false;
        }

        if (board[i][j] != word.charAt(idx)) {
            return false;
        }

        char temp   = board[i][j]; 
        board[i][j] = '$';

        boolean found =
            solve(i + 1, j, idx + 1, board, word) ||
            solve(i - 1, j, idx + 1, board, word) ||
            solve(i, j + 1, idx + 1, board, word) ||
            solve(i, j - 1, idx + 1, board, word);

        board[i][j] = temp;

        return found;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(board[i][j] == word.charAt(0)) {
                    if(solve(i, j, 0, board, word)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}