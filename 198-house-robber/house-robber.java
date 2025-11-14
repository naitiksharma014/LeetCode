class Solution {
    int[] dp;
    public int solve(int i , int[] nums , int n){
        if(i >= n) return 0;
        
        if(dp[i] != -1) return dp[i];

        int steal = nums[i] + solve(i + 2 , nums , n);
        int skip = solve(i + 1 , nums , n);

        return dp[i] = Math.max(skip , steal);
    }
    public int rob(int[] nums) {
        int n = nums.length;

        dp = new int[n + 1];
        for(int i = 0 ; i < n + 1 ; i++){
            dp[i] = -1;
        }

        return solve(0 , nums , n);
    }
}