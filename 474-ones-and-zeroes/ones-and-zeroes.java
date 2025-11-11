class Solution {
    int[][][] dp;
    public int solve(int[][] res, int m, int n, int i){
        if(i >= res.length || (m == 0 && n == 0)) return 0;

        if(dp[m][n][i] != -1) return dp[m][n][i];

        int take = 0;
        if(res[i][0] <= m && res[i][1] <= n){
            take = 1 + solve(res, m - res[i][0], n - res[i][1], i + 1);
        }
        int skip = solve(res, m, n, i + 1);

        return dp[m][n][i] = Math.max(take , skip);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int L = strs.length;
        int[][] res = new int[L][2];

        for(int i = 0; i < L; i++){

            int countZero = 0;
            int countOne = 0;

            for(char ch : strs[i].toCharArray()){

                if(ch == '1'){
                    countOne++;
                }
                else{
                    countZero++;
                }
            }

            res[i][0] = countZero;
            res[i][1] = countOne;
        }

        dp = new int[m + 1][n + 1][L];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(res, m, n, 0);
    }
}