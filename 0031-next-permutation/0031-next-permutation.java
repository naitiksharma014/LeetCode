// TC: O(n)

class Solution {

    public void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public void reverse(int[] nums, int l, int r) {
        while(l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = -1;

        for(int i = n - 1; i > 0; i--) {

            if(nums[i] > nums[i - 1]) {
                idx = i - 1;
                break;
            }
        }

        int swapIdx = -1;
        if(idx != -1) {

            for(int i = n - 1; i > idx; i--) {

                if(nums[i] > nums[idx]) {
                    swapIdx = i;
                    break;
                }
            }
        }

        if(swapIdx != -1 && idx != -1) {
            swap(nums, idx, swapIdx);
        }

        reverse(nums, idx + 1, n - 1);
    }
}