// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {
    int n;
    Integer[][] dp;

    public int solve(int[] prices, int i, int canBuy) {
        if(i >= n) {
            return 0;
        }

        if(dp[i][canBuy] != null) {
            return dp[i][canBuy];
        }

        int profit = 0;

        if(canBuy == 1) {   

            int buyStock = -prices[i] + solve(prices, i + 1, 0);    // profit = sell( solve() ) - buy( prices[i] )
            int skipStock = solve(prices, i + 1, 1);

            profit = Math.max(buyStock, skipStock);

        } else {

           int sellStock = prices[i] + solve(prices, i + 1, 1);
           int holdStock = solve(prices, i + 1, 0);

           profit = Math.max(sellStock, holdStock);
        }

        return dp[i][canBuy] = profit;
    }
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new Integer[n + 1][2];

        return solve(prices, 0, 1);
    }
}