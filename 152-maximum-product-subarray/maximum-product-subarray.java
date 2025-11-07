class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prodStart = 1;
        int prodEnd = 1;
        int res = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(prodStart == 0) prodStart = 1;
            if(prodEnd == 0) prodEnd = 1;

            prodStart *= nums[i];
            prodEnd *= nums[n-i-1];

            res = Math.max( res , Math.max(prodStart , prodEnd) );
        }
        return res;
    }
}