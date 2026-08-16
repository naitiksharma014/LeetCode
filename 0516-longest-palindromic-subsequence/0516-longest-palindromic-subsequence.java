// Without Memorization:
    //  Time: O(2^n)
    //  Space: O(n) recursion stack

// With Memorization:
    //  Time: O(n²)
    //  Space: O(n² + n) = O(n²); O(n) for recursion stack
    
class Solution {
    int n;
    Integer[][] dp = new Integer[1001][1001];

    public int solve(String s, int i, int j) {
        if(i > j) {
            return 0;
        }

        if(i == j) {    // middle
            return 1;
        }

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        int match = 0, not_match = 0;
        if(s.charAt(i) == s.charAt(j)) {
            match = 2 + solve(s, i + 1, j - 1);
        } else {
            not_match = Math.max(solve(s, i + 1, j), solve(s, i, j - 1));
        }

        return dp[i][j] = Math.max(match, not_match);
    }
    public int longestPalindromeSubseq(String s) {
        n = s.length();

        return solve(s, 0, n - 1);
    }
}