class Solution {
    public int findLucky(int[] arr) {
        int n = arr.length;
        int[] freq = new int[501];
        
        for( int i=0 ; i<n ; i++ ){
            freq[ arr[i] ]++;
        }

        int max = -1;
        for( int i=0 ; i<501 ; i++ ){
            if( freq[i] == i && freq[i] != 0 ){
                max = freq[i];
            }
        }
        return max;
    }
}