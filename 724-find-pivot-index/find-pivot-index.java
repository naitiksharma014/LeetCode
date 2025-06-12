class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int totalSum = 0;
        int leftSum = 0;
        
        //TOTAL SUM
        for( int i=0 ; i<n ; i++ ){
            totalSum += nums[i];
        }

        //LEFT SUM : rightSum = totalSum - leftSum - num[i]
        for( int i=0 ; i<n ; i++ ){
            leftSum += nums[i];

            if( totalSum == leftSum * 2 - nums[i] ){
                return i;
            }
        }
        return -1;
    }
}