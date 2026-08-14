// Time: O(n²)
// Space: O(n²) + O(n) recursion stack

class Solution {
    int n;
    int[][] dp;

    public int solve(int[] nums, int prev, int curr) {
        if(curr == n) {
            return 0;
        }

        if(dp[prev + 1][curr] != -1) {
            return dp[prev + 1][curr];
        }

        int take = 0;
        if(prev == -1 || nums[prev] < nums[curr]) {
            take = 1 + solve(nums, curr, curr + 1);
        }

        int skip = solve(nums, prev, curr + 1);

        return dp[prev + 1][curr] = Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {
        n = nums.length;

        dp = new int[n + 1][n];
        for(int[] row: dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, -1, 0);
    }
}