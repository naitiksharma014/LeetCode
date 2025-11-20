class Solution {
    int m, n;
    int[][] dp;

    public int solve(String t1, String t2, int i, int j){
        if(i >= m || j >= n){
            return 0;
        }
         
        if(dp[i][j] != -1) return dp[i][j];

        if(t1.charAt(i) == t2.charAt(j)) {
            return dp[i][j] = 1 + solve(t1, t2, i+1, j+1);
        } 
        else{
            return dp[i][j] = Math.max(solve(t1, t2, i+1, j), solve(t1, t2, i, j+1));
        }
        
    }
    public int longestCommonSubsequence(String text1, String text2) {
        m = text1.length();
        n = text2.length();

        dp = new int[1001][1001];
        for(int i = 0; i < m; i++){
            Arrays.fill(dp[i] , -1);
        }

        return solve(text1, text2, 0, 0);
    }
}