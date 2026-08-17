// Time: O(n²)
// Space: O(n) (memo array + recursion stack)

class Solution {
    Integer[] dp;

    public int solve(int n) {
        if(n <= 1) {
            return 1;
        }

        if(n == 2) {
            return 2;
        }

        if (dp[n] != null) {
            return dp[n];
        }

        int ans = 0;
        for(int root = 1; root <= n; root++) {

            int left = solve(root - 1);
            int right = solve(n - root);

            ans += (left * right);
        }

        return dp[n] = ans;
    }

    public int numTrees(int n) {
        dp = new Integer[20];

        return solve(n);
    }
}