class Solution {
    int[] t;
    public int solve(int i , int[] nums , int n , int[] t){
        if(i >= n) return 0;
        
        if(t[i] != -1) return t[i];

        int steal = nums[i] + solve(i + 2 , nums , n , t);
        int skip = solve(i + 1 , nums , n , t);

        return t[i] = Math.max(skip , steal);
    }
    public int rob(int[] nums) {
        int n = nums.length;

        t = new int[n + 1];
        for(int i = 0 ; i < n + 1 ; i++){
            t[i] = -1;
        }

        return solve(0 , nums , n , t);
    }
}