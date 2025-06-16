class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int max = -1;
        int i = 0;

        for( int j=1 ; j<n ; j++ ){
            if( i<j && nums[i]<nums[j] ){
                max = Math.max( max , nums[j] - nums[i] );
            }
            else {
                i = j;
            }
        }
        return max;
    }
}