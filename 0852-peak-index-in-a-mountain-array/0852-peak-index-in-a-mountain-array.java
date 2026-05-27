//----------------------------------------(Approach - 2)-------------------------------
// Optimal: Binary Search
// TC: O(log n)

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;

        while(l <= r) {
            
            int mid = l + (r - l)/2;

            if(arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return l;
    }
}