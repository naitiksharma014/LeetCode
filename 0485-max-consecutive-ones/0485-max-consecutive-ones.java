class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxOnes = 0;
        int ones = 0;

        for(int num: nums) {

            if(num == 1) {
                ones++;
            } else {
                ones = 0;
            }

            maxOnes = Math.max(maxOnes, ones); 
        }

        return maxOnes;
    }
}