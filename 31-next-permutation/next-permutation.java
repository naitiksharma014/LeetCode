class Solution {
    public void swap( int[] nums , int a , int b , int n ){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void reverse( int[] nums , int a , int b , int n){
        while( a < b ){
            swap( nums , a , b , n );
            a++;
            b--;
        }
    }
    
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int gola_index = -1;

        for( int i=n-1 ; i>0 ; i-- ){
            if( nums[i-1] < nums[i] ){
                gola_index = i-1;
                break;
            }
        }
        
        int swap_index = -1;
        if( gola_index != -1 ){
            for( int i=n-1 ; i>=gola_index ; i-- ){
               if( nums[gola_index] < nums[i] ){
                 swap_index = i;
                 break;
                }
            }
            swap( nums , gola_index , swap_index , n );
        }
        
        

        reverse( nums , gola_index+1 , n-1 , n );
    }
}