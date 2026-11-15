// TC: O(N * Target)
// SC: O(Target)

class Solution {
    int n;
    Integer[] dp = new Integer[1001];

    public int solve(int sum, int[] nums, int target) {
        if(sum > target) {
            return 0;
        }

        if(sum == target) {
            return 1;
        }

        if(dp[sum] != null) {
            return dp[sum];
        }

        int count = 0;

        for(int i = 0; i < n; i++) {

            sum += nums[i];
            
            count += solve(sum, nums, target);

            sum -= nums[i];
            
        }

        return dp[sum] = count;
    }

    public int combinationSum4(int[] nums, int target) {
        n = nums.length;

        return solve(0, nums, target);
    }
}