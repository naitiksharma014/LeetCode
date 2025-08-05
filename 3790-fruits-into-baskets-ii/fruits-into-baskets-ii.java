class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;

        int count = 0;

       for( int i = 0 ; i < n ; i++ ){
           for( int j = 0 ; j < n ; j++ ){
                if( fruits[i] <= baskets[j] ){
                    count++;
                    baskets[j] = 0;
                    break;
                }
            }
        }
        return n - count;
    }
}