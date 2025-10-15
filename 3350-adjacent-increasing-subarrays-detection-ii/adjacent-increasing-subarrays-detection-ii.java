class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();

        int currCount = 1;
        int prevCount = 0;
        int k = 0;

        for(int i = 1 ; i < n ; i++){
            if(nums.get(i) > nums.get(i - 1)){
                currCount++;
            }
            else{
                prevCount = currCount;
                currCount = 1;
            }

            k = Math.max(k , currCount / 2);
            k = Math.max(k , Math.min(currCount , prevCount));

        }
        return k;
    }
}