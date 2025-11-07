class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        int count = 0;

        if(n == 1) return nums[0];
        Arrays.sort(nums);

        for(int i = 0; i < n-1; i++){
            if(nums[i] == nums[i+1]){
                count++;

                if(count == n / 2) return nums[i];
            }
            else count = 0;
        }
        return -1;
    }
}