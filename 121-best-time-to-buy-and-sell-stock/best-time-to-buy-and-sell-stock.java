class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int buyStock = prices[0];
        int maxProfit = 0;
        
        for( int i=1 ; i<n ; i++ ){
            if( buyStock < prices[i] ){
                maxProfit = Math.max( maxProfit , prices[i] - buyStock );
            }

            else{
                buyStock = prices[i];
            }

        }
        return maxProfit;
    }
}