class Solution {
    public int solve(int[] values , int i , int j , int[][] dp){
        int result = Integer.MAX_VALUE;

        if( (j - i + 1) < 3 ) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        for(int k = i+1 ; k < j ; k++){

            int wt = values[i] * values[j] * values[k] + solve(values , i , k , dp) + solve(values , k , j , dp);

            result = Math.min(result , wt);
        }

        dp[i][j] = result;

        return result;
    }
    public int minScoreTriangulation(int[] values) {
        int n = values.length;

        int[][]dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

       return solve(values , 0 , n-1 , dp);
    }
}