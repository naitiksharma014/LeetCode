// TC: O(n)

class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;

        int lastZeroIdx = -1;
        int i = 0, j = 0;
        int ans = 0;

        while(j < n) {

            if(nums[j] == 0) {

                i = lastZeroIdx + 1;
                lastZeroIdx = j;
            }

            j++;

            ans = Math.max(ans, j - i - 1);
        }

        return ans;
    }
}