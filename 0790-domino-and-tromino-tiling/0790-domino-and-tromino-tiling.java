// ⏱️ Time: O(n)
// 📦 Space: O(n) (dp + recursion stack)

class Solution {
    int M = 1000000007;
    Integer[] dp = new Integer[1001];

    public int solve(int n) {
        if(n == 1 || n == 2) return n;
        if(n == 3) return 5;

        if(dp[n] != null) {
            return dp[n];
        }

        return dp[n] = (2 * solve(n - 1) % M + solve(n - 3) % M) % M;
    }

    public int numTilings(int n) {
        return solve(n);
    }
}