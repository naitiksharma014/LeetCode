class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        int res = 0;

        for(int num : nums){

            if(num % 3 == 1 || num % 3 == 2) res++;
            
        }

        return res;
    }
}