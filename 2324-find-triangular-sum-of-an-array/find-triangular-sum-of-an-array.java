class Solution {
    public int triangularSum(int[] nums) {
       int n = nums.length;
       

       while(nums.length > 1){
           int[] temp = new int[nums.length - 1];

           for(int i = 0 ; i < nums.length - 1; i++){

               temp[i] = (nums[i] + nums[i + 1]) % 10;
            }

            nums = temp;
        } 

        return nums[0];
    }
}