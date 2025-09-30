class Solution {
    public int triangularSum(int[] nums) {
       int n = nums.length;
       int k = 1;

       while(k != nums.length){
          
           for(int i = 0 ; i < nums.length - 1; i++){

               nums[i] = (nums[i] + nums[i + 1]) % 10;
            }

            k++;
        } 

        return nums[0];
    }
}