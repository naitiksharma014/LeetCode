class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;
        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        int sum = 0;
        int count = 0;
        
        for(int i=0; i<n-1; i++){
            int num = nums[i];
            sum += num;

            if(Math.abs(2 * sum - totalSum) % 2 == 0){
                count++;
            }
        }

        return count;
    }
}