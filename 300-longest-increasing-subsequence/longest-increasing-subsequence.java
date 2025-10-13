class Solution {
    int n;
    int[][] t;
    public int solve(int[] nums , int i , int p , int[][] t){
        if(i >= n) return 0;
        
        if(p != -1 && t[i][p] != -1) return t[i][p];

        int take = 0;
        if(p == -1 || nums[i] > nums[p]){
            take = 1 + solve(nums , i + 1 , i , t);
        }
        int skip = solve(nums , i + 1 , p , t);
        
        if(p != -1){
            t[i][p] = Math.max(skip , take);
        }
        return Math.max(skip , take);
    }
    public int lengthOfLIS(int[] nums) {
        n = nums.length;
        
        t = new int[2501][2501];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                t[i][j] = -1;
            }
        }

        return solve(nums , 0 , -1 , t);
    }
}