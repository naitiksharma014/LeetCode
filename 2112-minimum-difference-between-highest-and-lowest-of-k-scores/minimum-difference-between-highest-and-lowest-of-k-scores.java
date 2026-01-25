class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        if(n == 1) return 0;
        
        Arrays.sort(nums);
        
        int ans = Integer.MAX_VALUE;
        int i = 0;

        while(i + k - 1 < n){
           ans = Math.min(ans, nums[i + k - 1] - nums[i]);
           i++;
        }

        return ans;
    }
}