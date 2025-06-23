class Solution {
    public int find_pivot( int[] nums , int n ){
        int l = 0;
        int r = n-1;

        while( l < r ){
            int mid = l + ( r - l )/2;
            if( nums[mid] > nums[r] ){
                l = mid + 1;
            }
            else {
                r = mid;
            }
        }
        return r;
    }

    public int binarySearch( int l , int r , int[] nums , int n , int tar ){
        int idx = -1;
        while( l <= r ){
            int mid = l + ( r - l )/2;
            if( nums[mid] == tar ){
                idx = mid;
                break;
            }
            else if( nums[mid] < tar ){
                l = mid + 1;
            }
            else{
                r = mid-1;
            }
        }
        return idx;
    }
    public int search(int[] nums, int target) {
        int n = nums.length;

        int pivot = find_pivot( nums , n );

        int idx = binarySearch( 0 , pivot - 1, nums , n , target );
        if( idx != -1 ){
           return idx;
        }
        idx = binarySearch( pivot , n - 1 , nums , n , target );
        return idx;
    }
}