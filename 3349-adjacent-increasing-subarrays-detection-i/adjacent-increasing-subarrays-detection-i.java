class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        int currCount = 1;
        int prevCount = 0;

        for(int i = 1 ; i < n ; i++){

            if(nums.get(i) > nums.get(i - 1)){
                currCount++;
            }
            else{
                prevCount = currCount;
                currCount = 1;
            }

            if(currCount / 2 >= k) return true;

            if(Math.min(currCount , prevCount) >= k) return true;
        }   

        return false;
    }
}