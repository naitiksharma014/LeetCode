class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        int zero = 0;
        int max = Integer.MIN_VALUE;

        while( r<n ){
            if( nums[r] == 0 ){
                zero++;
                
            }
            while( zero > 1 ){
                if( nums[l] == 0 ){
                    zero--;
                }
                l++;
            }
            max = Math.max( max , r - l );
            r++;
        }
        return max;
    }
}