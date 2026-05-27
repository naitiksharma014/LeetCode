//-----------------------------------------------------------------------------(Approach - 1)-------------------------------------------------------------------------
// Linear Approach
// TC: O(n)

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int i = 0;

        while(i < n - 1 && arr[i] < arr[i + 1]) {
            i++;
        }
        return i;
    }
}

//-----------------------------------------------------------------------------(Approach - 2)-------------------------------------------------------------------------
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
