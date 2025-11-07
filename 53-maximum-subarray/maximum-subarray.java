class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int res = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(sum < 0) sum = 0;
            
            sum += nums[i];
            res = Math.max(res , sum);
        }

        return res;
    }
}