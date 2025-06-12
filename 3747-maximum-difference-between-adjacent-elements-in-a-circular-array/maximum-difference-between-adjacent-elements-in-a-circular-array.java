class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int diff = 0;
        int maxDiff = Integer.MIN_VALUE;
        int i = 0 , j = 1;

        while(i<j){
            if( j == n ){
                j = 0;
            }
            if( i == n ){
                i = 0;
            }
            diff = Math.abs( nums[i] - nums[j] );
            maxDiff = Math.max( diff , maxDiff );
            i++;
            j++;

        }
        return maxDiff;
    }
}