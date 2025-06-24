class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
       int n = nums.length;
       ArrayList<Integer> list = new ArrayList<>();
        

        for( int i=0 ; i<n ; i++ ){
            if( nums[i] == key ){
                int start = Math.max( i-k , 0 );
                int end = Math.min( i+k , n-1 );

                if( !list.isEmpty() && list.get( list.size() - 1 ) >= start ){
                    start = list.get( list.size() - 1 ) + 1;
                }

                for( int j=start ; j<=end ; j++ ){
                    list.add( j );
                }
            }
        }
        return list;
    }
}