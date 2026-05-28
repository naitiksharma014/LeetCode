// TC: O(log n)
// SC: O(1)

class Solution {
    int n;

    public int findPivot(int[] nums) {
        int l = 0, r = n - 1;

        while(l < r) {
            int mid = l + (r - l) / 2;

            if(nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return r;
    }

    public int BinarySearch(int[] nums, int t, int l, int r) {
        while(l <= r) {
            int mid = l + (r - l) / 2;

            if(nums[mid] == t) {
                return mid;
            } else if(nums[mid] > t) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        n = nums.length;

        int pivotIdx = findPivot(nums);

        int idx = BinarySearch(nums, target, 0, pivotIdx - 1);

        if(idx != -1) {
            return idx;
        }

        idx = BinarySearch(nums, target, pivotIdx, n - 1);

        return idx;
    }
}