class Solution {
    public int maxSubArray(int[] nums) {
        //KADANE ALGO

        int n = nums.length;
        int currSum = 0;
        int max = nums[0];
        
        for(int i: nums){
            currSum += i;
            max = Math.max( max , currSum );
            if( currSum < 0 ){
                currSum = 0;
            }
        }

        return max;
    }
}