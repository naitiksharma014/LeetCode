// TC: O(n)
// SC: (O(n) 

class Solution {
    Integer[] dp = new Integer[46];

    public int climbStairs(int n) {
        if(n < 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }

        if(dp[n] != null) {
            return dp[n];
        }

        return dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
    }
}