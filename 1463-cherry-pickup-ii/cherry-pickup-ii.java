// DP + Memorization
// TC: O(m * n * n) = O(m * n²)
// SC: O(m * n²)

class Solution {
    int m, n;
    int[][][] dp;

    public int solve(int r, int c1, int c2, int[][] grid) {
        if(r >= m) {
            return 0;
        }

        if(dp[r][c1][c2] != -1) {
            return dp[r][c1][c2];
        }

        int cherry = grid[r][c1];
        if(c1 != c2) {
            cherry += grid[r][c2];
        }

        int ans = 0;
        for(int i = -1; i <= 1; i++) {
            for(int j = -1; j <= 1; j++) {

                int new_r = r + 1;
                int new_c1 = c1 + i;
                int new_c2 = c2 + j;

                if(new_c1 >= 0 && new_c1 < n && new_c2 >= 0 && new_c2 < n) {
                    ans = Math.max(ans, solve(new_r, new_c1, new_c2, grid));
                }
            }
        }

        return dp[r][c1][c2] = cherry + ans;
    }
    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[71][71][71];
        for(int[][] twoD: dp) {
            for(int[] oneD: twoD) {
                Arrays.fill(oneD, -1);
            }
        }

        return solve(0, 0, n -1, grid);
    }
}