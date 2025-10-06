class Solution {
    public int minIncrementForUnique(int[] nums) {
        int n = nums.length;
        int moves = 0;

        Arrays.sort(nums);

        for(int i = 1 ; i < n ; i++){
            if(nums[i] <= nums[i - 1]){
                moves += (nums[i - 1] - nums[i] + 1);
                nums[i] = nums[i - 1] + 1;
            }
        }   
        return moves;
    }
}