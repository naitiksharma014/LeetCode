class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        int result[] = new int[2001];

        for( int x : arr ){
            result[ x + 1000 ]++;
        }

        Arrays.sort( result );

        for( int i=1 ; i<2001 ; i++){
            if( result[i]!=0 && result[i] == result[i-1] ){
                return false;
            }
        }
        return true;
    }
}