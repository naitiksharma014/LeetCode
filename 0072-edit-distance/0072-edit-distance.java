// ⏱️ TC: O(m × n)
// 💾 SC: O(m × n) 

class Solution {
    int m, n;
    Integer[][] dp = new Integer[501][501];

    public int solve(String word1, String word2, int i, int j) {
        if(i == m) {
            return n - j;
        }
        if(j == n) {
            return m - i;
        }

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        if(word1.charAt(i) == word2.charAt(j)) {
            return solve(word1, word2, i + 1, j + 1);
        }

        int insert = 1 + solve(word1, word2, i, j + 1);
        int delete = 1 + solve(word1, word2, i + 1, j);
        int replace = 1 + solve(word1, word2, i + 1, j + 1); 

        return dp[i][j] = Math.min(replace, Math.min(insert, delete));
    }

    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();

        return solve(word1, word2, 0, 0);
    }
}