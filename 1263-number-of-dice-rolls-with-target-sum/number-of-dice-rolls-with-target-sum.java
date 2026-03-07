// Bottom Up
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