class Solution {
    public void sortColors(int[] nums) {
        int i=0,j=0,k=0;
        int ans[]=new int[nums.length];

        for(int l=0;l<nums.length;l++){
            if(nums[l]==0)i++;
            else if(nums[l]==1)j++;
            else k++;
        }

        for(int l=0;l<i;l++){
            nums[l]=0;
        }
         for(int l=i;l<i+j;l++){
            nums[l]=1;
        }
         for(int l=i+j;l<i+j+k;l++){
            nums[l]=2;
        }
        // return nums;

       
        
    }
}