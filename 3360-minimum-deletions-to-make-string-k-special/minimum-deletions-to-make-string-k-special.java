class Solution {
    public int minimumDeletions(String word, int k) {
        int max = word.length(); 

        int freq[] = new int [26];
        // for( int a=0 ; a<n ; a++ ){
        //     char ch = word.charAt(a);
        //     freq[ ch - 'a' ]++;
        // }
        for( char ch : word.toCharArray() ){
            freq[ ch - 'a' ]++;
        }
        
        // int max = Integer.MIN_VALUE;
        for( int i=0 ; i<26 ; i++ ){
            int del = 0;

            for( int j=0 ; j<26 ; j++ ){
                if( i == j ) continue;

                if( freq[j] < freq[i] ){
                    del += freq[j];
                }
                else if( Math.abs( freq[j] - freq[i] ) > k ){
                    del += Math.abs( freq[j] - freq[i] - k );
                }
                 
            }
            max = Math.min( max , del );
        }

        return max;
    }   

}