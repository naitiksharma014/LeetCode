// Time	O(m × n)
// Space	O(m × n) for DP
// Recursion stack	O(m + n)

class Solution {
    Integer[][] dp;

    public int solve(int i, int j, int m, int n) {
        if(i == m - 1 && j == n - 1) {
            return 1;
        }
        if(i >= m || j >= n) {
            return 0;
        }

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        int right = solve(i + 1, j, m, n);
        int down = solve(i, j + 1, m, n);

        return dp[i][j] = right + down;
    }
    public int uniquePaths(int m, int n) {
        dp = new Integer[m + 1][n + 1];

        return solve(0, 0, m, n);
    }
}