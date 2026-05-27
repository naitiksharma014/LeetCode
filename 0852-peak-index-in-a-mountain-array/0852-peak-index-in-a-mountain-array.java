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