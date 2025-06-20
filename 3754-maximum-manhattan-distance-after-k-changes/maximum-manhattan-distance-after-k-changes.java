class Solution {
    public int maxDistance(String s, int k) {
        int n = s.length();

        int east = 0;
        int west = 0;
        int north = 0;
        int south = 0;
        int max = Integer.MIN_VALUE;

        for( int i=0 ; i<n ; i++ ){
            if( s.charAt(i) == 'E') east++;
            else if( s.charAt(i) == 'W') west++;
            else if( s.charAt(i) == 'N') north++;
            else if ( s.charAt(i) == 'S') south++;

            int MD = Math.abs( east - west ) + Math.abs( north - south );
            int steps = i + 1;

            int wasted = steps - MD;

            int extra = 0;
            if( wasted != 0 ){
                extra = Math.min( 2*k , wasted );
            }

            int finalMD = MD + extra;

            max = Math.max( max , finalMD );
        }

       
         

        return max;
    }
}