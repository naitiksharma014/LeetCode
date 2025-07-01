class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int count = n;

        for( int i=0 ; i<n-1 ; i++ ){
            if( word.charAt(i) != word.charAt(i+1) ){
                count--;
            }
        }
        return count;
    }
}