class Solution {
    public int maxSubArray(int[] nums) {
        //KADANE ALGO

        int n = nums.length;
        int currSum = 0;
        int max = Integer.MIN_VALUE;
        
        for( int i=0 ; i<n ; i++){
            currSum += nums[i];
            max = Math.max( max , currSum );
            if( currSum < 0 ){
                currSum = 0;
            }
        }

        return max;
    }
}