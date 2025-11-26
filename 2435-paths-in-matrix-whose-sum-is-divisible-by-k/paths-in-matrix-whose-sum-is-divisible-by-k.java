class Solution {
    int m, n;
    int M = 1000000007;
    int[][][] dp;

    public int solve(int i, int j, int currSum, int k, int[][] grid){
        if(i >= m || j >= n) return 0;

        if(dp[i][j][currSum] != -1) return dp[i][j][currSum];

        if(i == m-1 && j == n-1){
            return (currSum + grid[i][j]) % k == 0 ? 1 : 0;
        }

        int down = solve(i + 1, j, (currSum + grid[i][j]) % k, k, grid);
        int right = solve(i, j + 1, (currSum + grid[i][j]) % k, k, grid);

        return dp[i][j][currSum] = (down + right) % M;
    }
    public int numberOfPaths(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        dp = new int[m+1][n+1][k];

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 0, 0, k, grid);
    }
}