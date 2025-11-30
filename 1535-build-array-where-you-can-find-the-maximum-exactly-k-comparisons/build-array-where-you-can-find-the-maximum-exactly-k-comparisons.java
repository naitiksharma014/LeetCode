// O(n) : n * m * k
class Solution {
    int N, M, K;
    int[][][] dp;
    int MOD = 1000000007;

    public int solve(int idx, int searchCost, int maxVal){
        int result = 0;

        if(idx >= N){
            if(searchCost == K){
                return 1;
            }
            return 0;
        }

        if(maxVal != -1 && dp[idx][searchCost][maxVal] != -1){
            return dp[idx][searchCost][maxVal];
        }

        for(int i = 1; i <= M; i++){

            if(i > maxVal){
                result = ( result + solve(idx + 1, searchCost + 1, i) ) % MOD;
            }
            else{
                result = ( result + solve(idx + 1, searchCost, maxVal) ) % MOD;
            }
        }
         
        if(maxVal != -1){
            return dp[idx][searchCost][maxVal] = result;
        }
        return result;
    }

    public int numOfArrays(int n, int m, int k) {
        N = n; M = m; K = k;

        dp = new int[51][51][101];

        for(int Matrix[][] : dp){
            for(int row[] : Matrix){
                Arrays.fill(row, -1);
            }
        }

        return solve(0, 0, -1);
    }    
}