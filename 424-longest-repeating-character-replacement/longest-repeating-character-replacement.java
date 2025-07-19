class Solution {

    public int getMax( int[] map ){
        int max = map[0];
        for( int i = 1 ; i < map.length ; i++ ){
            max = Math.max( max , map[i] );
        }
        return max;
    }

    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] map = new int[26];
        int ans = 0;
        int l = 0 , r = 0;

        while( r < n ){
            char ch = s.charAt(r);
            map[ch - 'A']++;
            int change = ( r - l + 1 ) - getMax( map );

            if( change <= k ){
                ans = Math.max( ans , r - l + 1 );
            }
            else{
                map[s.charAt(l) - 'A']--;
                l++;
            }
            r++;
        }
        return ans;
        
    }
}