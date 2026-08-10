// Time: 
    //  O(n × 2001)  With Memorization
    //  O(2ⁿ)        Without Memorization

// Space: O(n × S)
    //  DP table: O(n × S)
    //  Recursion stack: O(n)

class Solution {
    int offset = 1000;  // To manage -ve sum value as index in DP array
    int[][] dp;
    int n;

    public int solve(int[] nums, int t, int sum, int i) {
       if(i == n) {
            if(sum == t) {
                return 1;
            }
            return 0;
        }

        if(dp[i][offset + sum] != Integer.MIN_VALUE) {
            return dp[i][offset + sum];
        }

        int add = solve(nums, t, sum + nums[i], i + 1);
        int sub = solve(nums, t, sum - nums[i], i + 1);

        return dp[i][offset + sum] = add + sub;
    }

    public int findTargetSumWays(int[] nums, int target) {
        n = nums.length;

        dp = new int[22][2002];
        for(int[] row: dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        
        return solve(nums, target, 0, 0);
    }
}