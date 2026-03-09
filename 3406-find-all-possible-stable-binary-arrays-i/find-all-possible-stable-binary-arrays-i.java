// Top-Down (DP + Memorization)
// TC: O(one * zero * 2 * limit)
// SC: O(one * zero * 2)

class Solution {
    // flag = 0 -> false ; flag = 1 -> true
    int MOD = (int) 1e9 + 7;
    int[][][] dp;

    public int solve(int zero, int one, int limit, boolean flag){
        if(zero == 0 && one == 0){
            return 1;
        }

        int result = 0;
        int state = flag ? 1 : 0;

        if(dp[one][zero][state] != -1){
            return dp[one][zero][state];
        }

        if(flag){ // one

            for(int len = 1; len <= Math.min(one, limit); len++){

                result = (result + solve(zero, one - len, limit, false)) % MOD; 
            }
        } else { // zero

            for(int len = 1; len <= Math.min(zero, limit); len++){

                result = (result + solve(zero - len, one, limit, true)) % MOD; 
            }
        }
        
        return dp[one][zero][state] = result % MOD;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {

        dp = new int[201][201][2];
        for (int[][] layer : dp) {
            for (int[] arr : layer) {
                Arrays.fill(arr, -1);
            }
        }

        int start_with_0 = solve(zero, one, limit, false);
        int start_with_1 = solve(zero, one, limit, true);

        return (start_with_0 + start_with_1) % MOD;    
    }
}