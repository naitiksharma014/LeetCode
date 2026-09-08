// TC: O(n)
// SC: O(1)

class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;

        for(int i = 0; i < n; i++) {

            if(nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        while(j < n) {
            nums[j++] = 0;
        }
    }
}