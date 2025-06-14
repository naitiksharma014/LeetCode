class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if( m != n ){
            return false;
        }

        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for( int i=0 ; i<n ; i++ ){
            char idx1 = word1.charAt(i);
            char idx2 = word2.charAt(i);

            freq1[ idx1 - 'a' ]++;
            freq2[ idx2 - 'a' ]++;
        }

        for( int i=0 ; i<26 ; i++ ){
            if( freq1[i]==0 && freq2[i]==0 ) continue;
            if( freq1[i]!=0 && freq2[i]!=0 ) continue;
            return false;
        }

        Arrays.sort( freq1 );
        Arrays.sort( freq2 );
        for( int i=0 ; i<26 ; i++ ){
            if(  freq1[i]!= freq2[i] ) return false;
        }

        return true;
    }
}