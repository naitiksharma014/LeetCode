// TC: O(n)

class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        if (k == 0) {
            return nums;
        }

        int windowSize = 2 * k + 1;
        if (windowSize > n) {
            return ans;
        }

        long sum = 0;
        for(int i = 0; i < (2 * k + 1); i++) {
            sum += nums[i];
        }

        int start = k;
        ans[start++] = (int) (sum / windowSize);
        
        for(int i = windowSize; i < n; i++) {

           sum = sum - nums[i - windowSize] + nums[i];
           ans[start++] = (int) (sum / windowSize);
        }

        return ans;
    }
}