class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();
        int len = 0;
        int power = 1; //pow(2,0)

        for( int i=n-1 ; i>=0 ;i-- ){
            if( s.charAt(i) == '0' ){
                len++;
            }
            else if( power <= k ) {
               k = k - power;
               len++;
            }

            if( power <= k ){
                power *= 2;
            }
        }
        return len;
    }
}