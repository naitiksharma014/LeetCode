class Solution {
    int[] t;
    public int solve(int i , int[] nums , int n , int[] t){
        if(i > n) return 0;

        if(t[i] != -1) return t[i];

        int skip = solve(i + 1 , nums , n, t);
        int steal = nums[i] + solve(i + 2 , nums , n , t);

        return t[i] = Math.max(skip , steal);
    }
    
    public int rob(int[] nums) {
        int n = nums.length;
        
        t = new int[101];

        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0] , nums[1]);
        
        Arrays.fill(t, -1);
        int a = solve(0 , nums , n - 2 , t);

        Arrays.fill(t, -1);
        int b = solve(1 , nums , n - 1 , t);

        return Math.max(a , b); 
    }
}