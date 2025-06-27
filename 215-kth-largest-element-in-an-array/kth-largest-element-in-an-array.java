class Solution {
    public void swap( int[] nums , int a , int b ){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

     public int partition( int[] nums , int L , int R ){
        int  pivot = nums[L];
        int i = L+1;
        int j = R;

        while( i <= j ){
            if( nums[i] < pivot && nums[j] > pivot ){
                swap( nums , i , j );
                i++;
                j--;
            }
            if( nums[i] >= pivot ){
                i++;
            }
            if( nums[j] <= pivot ){
                j--;
            }
        }
        swap( nums , j , L );
        return j;
    }

    public int findKthLargest(int[] nums, int k) {
       int n = nums.length;

        int L = 0;
        int R = n-1;
        int pivot_idx = 0;

        //Kth Largest = nums[k-1]
        while( true ){
            pivot_idx = partition( nums , L , R );

            if( pivot_idx == k-1 ){
                break;
            }
            else if( pivot_idx > k-1 ){
                R = pivot_idx-1;
            }
            else {
                L = pivot_idx+1;
            }
        }
        return nums[pivot_idx]; 
    }
}