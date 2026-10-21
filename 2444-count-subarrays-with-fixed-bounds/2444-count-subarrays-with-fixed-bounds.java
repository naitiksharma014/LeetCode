// TC: O(n)

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;

        int minKPosition = -1;
        int maxKPosition = -1;
        int culpritPosition = -1;
        long ans = 0;

        for(int i = 0; i < n; i++) {

            if(nums[i] > maxK || nums[i] < minK) {
                culpritPosition = i;
            }

            if(nums[i] == maxK) {
                maxKPosition = i;
            }

            if(nums[i] == minK) {
                minKPosition = i;
            }

            long smaller = Math.min(minKPosition, maxKPosition);

            long temp = smaller - culpritPosition;

            ans += temp < 0 ? 0 : temp;
        }

        return ans;
    }
}