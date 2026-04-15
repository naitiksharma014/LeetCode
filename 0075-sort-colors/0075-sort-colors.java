// Dutch National Flag (DNF) Algorithm: 3 Pointer Approach
// ⏱️ TC: O(n)
// 💾 SC: O(1)

class Solution {
    
    public void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while(mid <= high) {

            if(nums[mid] == 0) {
                swap(nums, mid, low);
                mid++;
                low++;
            }

            else if(nums[mid] == 1) {
                mid++;
            }

            else {
                swap(nums, mid, high);
                mid++;
                high--;
            }
        }
    }
}