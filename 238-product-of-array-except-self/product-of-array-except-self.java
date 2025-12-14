class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int n = nums.length;

        int[] zeroArr = new int[n];
        int zero = 0;

        for(int i = 0; i < n; i++){
            
            if(nums[i] == 0){
                zeroArr[i]++;
                zero++;
            }
            if(nums[i] != 0){
                prod *= nums[i];
            }
                 
        }

        for(int i = 0; i < n; i++){
            
            if(zero > 1){
                nums[i] = 0;
            }
            else if(zero == 1){
               //nums[i] = (zeroArr[i] > 0) ? prod : 0;
                if (zeroArr[i] > 0) {
                    nums[i] = prod;
                } else {
                     nums[i] = 0;
                }
            }
            else {
                int temp = prod / nums[i];
                nums[i] = temp;
            }
           
        }

        return nums;
    }
}