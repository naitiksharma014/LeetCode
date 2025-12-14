//------------------------------------------------------------------------------(Approach - 1 : Simple)----------------------------------------------------------------------------------------------------
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




//------------------------------------------------------------------------------(Approach - 2 : Best Solution)----------------------------------------------------------------------------------------------------

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int [] prefix = new int[n];
        prefix[0] = 1;
        
        //Prefix Array
        for(int i=1;i<n;i++){
           prefix[i] = prefix[i-1] * nums[i-1];
        }

        int suffix = 1;
        for(int i=n-2;i>=0;i--){
            suffix *= nums[i+1];
            prefix[i] *= suffix;
        }
        return prefix;
        

    }
}
