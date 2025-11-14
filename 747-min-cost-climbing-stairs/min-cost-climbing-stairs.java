class Solution {
    int[] dp;
    public int solve(int[] cost , int i){
        int n = cost.length;

        if (i >= n) return 0;
        
        if(dp[i] != -1) return dp[i];
        int oneStep = cost[i] + solve(cost , i + 1);
        int twoStep = cost[i] + solve(cost , i + 2);

        return dp[i] = Math.min(oneStep , twoStep);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];

        Arrays.fill(dp , -1);
        return Math.min(solve(cost , 0) , solve(cost , 1));
    }
}