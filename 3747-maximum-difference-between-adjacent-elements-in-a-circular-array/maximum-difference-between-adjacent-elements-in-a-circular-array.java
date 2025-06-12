class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int maxDiff = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i=0 ; i<n ; i++){
            maxDiff = Math.max( maxDiff , Math.abs( nums[i] - nums[( i+1 ) % n] ) );
        }

        return maxDiff;
    }
}