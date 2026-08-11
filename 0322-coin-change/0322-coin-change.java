// TC: O(n × amount)
// SC: O(n × amount)

class Solution {
    int[][] dp;
    int n;

    public int solve(int[] coins, int t, int i, int sum) {

        if (sum == t) {
            return 0;
        }

        if (i >= n || sum > t) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }

        int take = Integer.MAX_VALUE;

        if (coins[i] <= t - sum) {
            take = solve(coins, t, i, sum + coins[i]);

            if (take != Integer.MAX_VALUE) {
                take++;
            }
        }

        int skip = solve(coins, t, i + 1, sum);

        return dp[i][sum] = Math.min(take, skip);
    }

    public int coinChange(int[] coins, int amount) {

        n = coins.length;

        dp = new int[n][amount + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = solve(coins, amount, 0, 0);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}