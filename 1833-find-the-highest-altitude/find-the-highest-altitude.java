class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int max = 0;
        int result[] = new int [n+1];
        result[0] = 0;

        for( int i=1 ; i<=n ; i++ ){
            result[i] = result[i-1] + gain[i-1];
            
        }
       for(int i=0 ; i<=n ; i++ ){
        max = Math.max( max , result[i] );
       
       }
       return max;
    }
}