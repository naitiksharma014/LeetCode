class Solution {
    public int maximumLength(int[] nums) {
       int n = nums.length;

       int even = 0;
       int odd = 0;

       for( int num : nums ){
          if( num % 2 == 0 ){
            even++;
          }
          else{
            odd++;
          }
        }

        int parity = nums[0] % 2;
        int Alternative = 1;

        for( int i=0 ; i<n ; i++ ){
            int currParity = nums[i] % 2;

            if( parity != currParity ){
                Alternative++;
            }
            parity = currParity;
        }

        return Math.max( Alternative , Math.max( odd , even ) );
    }
}