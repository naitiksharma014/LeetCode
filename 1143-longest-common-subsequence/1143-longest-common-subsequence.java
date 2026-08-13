// Time  = O(m × n)
// Space = O(m × n)

class Solution {
    int m, n;
    int[][] dp;

    public int solve(String text1, String text2, int i, int j) {
        if(i == m || j == n) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int take = 0;
        if(text1.charAt(i) == text2.charAt(j)) {
            take = 1 + solve(text1, text2, i + 1, j + 1);
        }

        int skip = Math.max(solve(text1, text2, i + 1, j), solve(text1, text2, i, j + 1));

        return dp[i][j] = Math.max(take, skip);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();

        dp = new int[m][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return solve(text1, text2, 0, 0);
    }
}