//-------------------------------------------------------------------------------------------------(Approach - 1)-------------------------------------------------------------------------------------------
// Top - Down (DP + Memorization)
// TC: O(n × target × k)
// SC: O(n × target)


class Solution {
    int MOD = 1000000007;
    int[][] dp;

    public int solve(int n, int k, int target){
        if(target < 0){
            return 0;
        }

        if(n == 0){
            return target == 0 ? 1 : 0;
        }

        if(dp[n][target] != -1){
            return dp[n][target];
        }

        int ways = 0;
        for(int faces = 1; faces <= k; faces++){
            ways = (ways + solve(n - 1, k, target - faces)) % MOD;
        }

        return dp[n][target] = ways;
    }

    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[31][1001];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return solve(n, k, target);
    }
}





//-------------------------------------------------------------------------------------------------(Approach - 2)-------------------------------------------------------------------------------------------
// Bottom - Up
// TC: O(n × target × k)
// SC: O(n × target)

class Solution {
    int MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[51][1001];
        dp[0][0] = 1;
 
        // i -> n, j -> target
        for(int i = 1; i <= n; i++){

            for(int j = 1; j <= target; j++){

                int ways = 0;

                for(int faces = 1; faces <= k; faces++){

                    if(j - faces >= 0){
                        ways = (ways + dp[i - 1][j - faces]) % MOD;
                    }
                }

                dp[i][j] = ways;
            }
        }

        return dp[n][target];
    }
}
