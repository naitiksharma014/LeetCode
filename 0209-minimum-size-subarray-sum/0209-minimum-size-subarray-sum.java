// TC: O(n)

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++) {

            sum += nums[i];

            while(sum >= target) {

                sum -= nums[left];
                minLen = Math.min(minLen, i - left + 1);
                left++;
            }
        }

        return minLen ==  Integer.MAX_VALUE ? 0 : minLen;
    }
}