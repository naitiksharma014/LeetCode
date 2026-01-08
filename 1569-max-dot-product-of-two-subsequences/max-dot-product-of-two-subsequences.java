class Solution {
    int m, n;
    int[][] dp;
    
    public int solve(int[] nums1, int[] nums2, int i, int j){
        if(i == m || j == n){
            return -100000000;
        }
        
        if(dp[i][j] != -100000000){
            return dp[i][j];
        }


        int val = nums1[i] * nums2[j];

        int take_i_j = val + solve(nums1, nums2, i + 1, j + 1);
        int take_j = solve(nums1, nums2, i + 1, j);
        int take_i = solve(nums1, nums2, i, j + 1);

        return dp[i][j] = Math.max(val, Math.max(take_i_j, Math.max(take_i, take_j)));
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        m = nums1.length;
        n = nums2.length;

        dp = new int[501][501];
        for(int[] row: dp){
            Arrays.fill(row, -100000000);
        }

        return solve(nums1, nums2, 0, 0);
    }
}