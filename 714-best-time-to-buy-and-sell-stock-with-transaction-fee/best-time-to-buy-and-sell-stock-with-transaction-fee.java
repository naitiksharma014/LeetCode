// DP + Memorization
// TC: O(n)
// SC: O(n)

class Solution {
    int n;
    Integer[][] dp = new Integer[50001][2];

    public int solve(int day, int[] prices, int fee, int isBuy) {
        if(day >= n) {
            return 0;
        }

        if(dp[day][isBuy] != null) {
            return dp[day][isBuy];
        }

        int profit = 0;

        if(isBuy == 1) {

            int Buy = solve(day + 1, prices, fee, 0) - prices[day];
            int not_Buy = solve(day + 1, prices, fee, 1);

            profit = Math.max(profit, Math.max(Buy, not_Buy));
        }
        else { // Sell

            int Sell = solve(day + 1, prices, fee, 1) + prices[day] - fee;
            int not_Sell = solve(day + 1, prices, fee, 0);

            profit = Math.max(profit, Math.max(Sell, not_Sell));
        }

        return dp[day][isBuy] = profit;
    }
    public int maxProfit(int[] prices, int fee) {
        n = prices.length;
        int isBuy = 1;

        return solve(0, prices, fee, isBuy);
    }
}