class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int firstIndex = -1;

        for(int i = 0; i < nums.length; i++){

            if(nums[i] == 1){
                if(firstIndex != -1 && i - firstIndex - 1 < k) return false;
                firstIndex = i;
            } 
        }

        return true;
    }
}