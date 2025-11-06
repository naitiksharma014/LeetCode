class Solution {
    public int maxElementIndex(int[] nums , int n){
        if(n == 0) return -1;
        int idx = 0;
        for(int i=1; i<n; i++){
            if(nums[i] > nums[idx]){
                idx = i;
            }
        }
        return idx;
    }
    public int minElementIndex(int[] nums , int n){
        if(n == 0) return -1;

        int idx = 0;
        for(int i=1; i<n; i++){
            if(nums[i] < nums[idx]){
                idx = i;
            }
        }
        return idx;
    }
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        if (n <= 2) return n;

        int maxIndex = maxElementIndex(nums , n);
        int minIndex = minElementIndex(nums , n);
        
        int s = Math.min(maxIndex,minIndex);
        int e = Math.max(maxIndex,minIndex);

        int cost_left_only = e + 1;
        int cost_right_only = n - s;
        int cost_both_ends = (s + 1) + (n - e);
        
      
        return Math.min(cost_left_only, Math.min(cost_right_only, cost_both_ends));
    }
}