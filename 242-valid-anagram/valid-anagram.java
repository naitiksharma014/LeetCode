class Solution {
    public boolean isAnagram(String s, String t) {
        // Map<Integer , Integer> mp1 = new HashMap<>();
        // Map<Integer , Integer> mp2 = new HashMap<>();
        int[] mp1 = new int[26];
        int[] mp2 = new int[26];

        for( char ch : s.toCharArray() ){
            mp1[ ch - 'a' ]++;
        }
        for( char ch : t.toCharArray() ){
            mp2[ ch - 'a' ]++;
        }
        for( int i=0 ; i<26 ; i++ ){
            if( mp1[i] != mp2[i] ){
                return false;
            }
        }
        return true;

    }
}