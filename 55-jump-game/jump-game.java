class Solution {
    public boolean canJump(int[] nums) {
       int n = nums.length;
       int coverage = 0;

       for(int i = 0 ; i < n ; i++){
           
           if(coverage < i) return false;

           coverage = Math.max(coverage , i + nums[i]);
        } 
        return true;
    }
}