class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;

        int result = 0;
        int curr = 0;
        int totalSum = 0;

        for(int num : nums){
            totalSum += num;
        }

        for(int num : nums){

            curr += num;

            int left = curr;
            int right = totalSum - left;

            if(num != 0){
                continue;
            }

            if(left == right){
                result += 2;
            }

            if(Math.abs(left - right) == 1){
                result += 1;
            }
        }

        return result;
    }
}