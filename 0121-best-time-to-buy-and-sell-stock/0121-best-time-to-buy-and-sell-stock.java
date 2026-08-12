// TC: O(n)
// Sc: O(1)

class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int bestBuy = prices[0];    // It should be minimum among the array
        int maxProfit = 0;

        for(int price: prices) {

            if(price > bestBuy) {
                maxProfit = Math.max(maxProfit, price - bestBuy);
            }

            bestBuy = Math.min(bestBuy, price);
        }

        return maxProfit;
    }
}