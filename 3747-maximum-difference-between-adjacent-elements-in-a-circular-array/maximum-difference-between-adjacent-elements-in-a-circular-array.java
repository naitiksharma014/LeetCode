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

//MY SOLUTION - O(n)

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
