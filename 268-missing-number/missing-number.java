class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int num: nums){
            
            sum += num;
        }

        int actualSum = n * ( n + 1) / 2;

        return actualSum - sum;
    }
}