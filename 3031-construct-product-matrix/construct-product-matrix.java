// ⏱️ Time → O(m * n)
// 💾 Space → O(1) (excluding output) 

class Solution {
    int MOD = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;     // Row
        int n = grid[0].length;  // Col

        int[][] p = new int[m][n];

        long suffix = 1;
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                p[i][j] = (int) suffix;
                suffix = (suffix * grid[i][j]) % MOD;
            }
        }

        long prefix = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                p[i][j] = (int) (prefix * p[i][j]) % MOD;
                prefix = (prefix * grid[i][j]) % MOD;
            }
        }

        return p;
    }
}