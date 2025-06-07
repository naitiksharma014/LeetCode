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