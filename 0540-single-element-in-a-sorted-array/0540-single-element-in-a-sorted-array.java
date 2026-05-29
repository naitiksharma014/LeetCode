// TC: O(log n)
// SC: O(1)

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;

        boolean isEven = true;

        while(l < r) {
            
            int mid = l + (r - l) / 2;

            if((r - mid) % 2 == 0) {
                isEven = true;
            } else {
                isEven = false;
            }


            if(nums[mid] == nums[mid + 1]) {

                if(isEven) {    // go right
                    l = mid + 2;
                } else {        // go left
                    r = mid - 1;
                }

            } else {

                if(isEven) {    // go left
                    r = mid;
                } else {        // go right
                    l = mid + 1;
                }
            }
        }

        return nums[r];
    }
}