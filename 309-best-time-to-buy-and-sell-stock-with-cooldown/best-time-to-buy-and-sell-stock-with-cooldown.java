// DP + Memorization
// TC: O(n)
// SC: O(n)

class Solution {
    int n;
    Integer[][] dp = new Integer[5001][2];

    public int solve(int day, int[] prices, int buy) {
        if(day >= n) {
            return 0;
        }

        if(dp[day][buy] != null) {
            return dp[day][buy];
        }

        int profit = 0;

        if(buy == 1) {
            int take     = solve(day + 1, prices, 0) - prices[day];

            int not_take = solve(day + 1, prices, 1);

            profit = Math.max(profit, Math.max(take, not_take));
        }
        else {
            int sell     = prices[day] + solve(day + 2, prices, 1);

            int not_sell = solve(day + 1, prices, 0);

            profit = Math.max(profit, Math.max(sell, not_sell));
        }

        return dp[day][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        n = prices.length;
        int buy = 1;

        // True-> 1 and False-> 0
        return solve(0, prices, buy);
    }
}