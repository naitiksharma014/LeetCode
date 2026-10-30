// TC: O(n)

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;

        long maxNum = Integer.MIN_VALUE;
        for(int num: nums) {
            maxNum = Math.max(maxNum, num);
        }

        int i = 0, j = 0;
        int count = 0;
        long ans = 0;

        while(j < n) {

            int curr = nums[j];
            if(curr == maxNum) {
                count++;
            }

            while(count >= k) {

                ans += (n - j);

                int prev = nums[i];
                if(prev == maxNum) {
                    count--;
                }

                i++;
            }
            
            j++;
        }

        return ans;
    }
}