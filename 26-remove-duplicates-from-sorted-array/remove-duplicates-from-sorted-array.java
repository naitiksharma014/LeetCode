class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i = 1;
        int idx = 0;

        while(i<n){
            if(nums[idx] != nums[i]){
               
                idx++;
                nums[idx] = nums[i];
            }
            i++;
        }

        return idx+1;
    }
}