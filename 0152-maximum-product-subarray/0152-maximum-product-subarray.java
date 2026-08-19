// TC: O(n)
// SC: O(1)

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;

        int startProduct = 1;
        int endProduct = 1;

        for(int i = 0; i < n; i++) {

            if(startProduct == 0) {
                startProduct = 1;
            }
            if(endProduct == 0) {
                endProduct = 1;
            }

            startProduct *= nums[i];
            endProduct   *= nums[n - 1 - i];

            maxProduct = Math.max(maxProduct, Math.max(startProduct, endProduct));
        }

        return maxProduct;
    }
}