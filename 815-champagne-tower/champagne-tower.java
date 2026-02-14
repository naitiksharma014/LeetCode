class Solution {
    double[][] dp;

    public double solve(int poured, int i, int j){
        if(i < 0 || j < 0 || i < j){
            return 0.0;
        }

        if(i == 0 && j == 0){
            return poured;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        double topLeft  = (solve(poured, i - 1, j - 1) - 1) / 2.0;
        double topRight = (solve(poured, i - 1, j) - 1) / 2.0;

        if(topLeft  < 0) topLeft = 0.0;
        if(topRight < 0) topRight = 0.0;

        return dp[i][j] = topLeft + topRight;
    }

    public double champagneTower(int poured, int query_row, int query_glass) {

        dp = new double[101][101];
    
        for(double[] row: dp){
            Arrays.fill(row, -1);
        }
        
        return Math.min(1.0, solve(poured, query_row, query_glass));

    }
}