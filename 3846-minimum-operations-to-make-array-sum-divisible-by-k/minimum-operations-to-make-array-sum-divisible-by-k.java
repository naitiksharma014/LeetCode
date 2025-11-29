class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        return sum % k;
    }
}