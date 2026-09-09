class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double maxAvg = 0.0;
        double avg = 0.0;
        int sum = 0;

        for(int i = 0; i < k; i++) {

            sum += nums[i];
        }

        maxAvg = (double) sum / k;

        for(int i = k; i < n; i++) {
            
            sum += nums[i] - nums[i - k];

            avg = (double) sum / k;

            maxAvg = Math.max(avg, maxAvg);
        }

        return maxAvg;
    }
}