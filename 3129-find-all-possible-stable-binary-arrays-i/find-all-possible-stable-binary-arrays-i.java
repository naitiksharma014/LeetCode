//------------------------------------------------------------------------------------------(Approach - 1)------------------------------------------------------------------------------------------
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



//------------------------------------------------------------------------------------------(Approach - 2)------------------------------------------------------------------------------------------
// Bottom-Up DP
// TC: O(zero * one * limit)
// SC: O(zero * one * 2)

class Solution {
    int MOD = (int) 1e9 + 7;

    public int numberOfStableArrays(int zero, int one, int limit) {
        int[][][] dp = new int[201][201][2];
        
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;

        for(int onesLeft = 0; onesLeft <= one; onesLeft++){

            for(int zerosLeft = 0; zerosLeft <= zero; zerosLeft++){

                if(onesLeft == 0 && zerosLeft == 0){
                    continue;
                }
                
                
                int result = 0;
                for(int len = 1; len <= Math.min(onesLeft, limit); len++){

                    result = (result + dp[onesLeft - len][zerosLeft][0]) % MOD;
                }
                dp[onesLeft][zerosLeft][1] = result;
                
                result = 0;
                for(int len = 1; len <= Math.min(zerosLeft, limit); len++){

                    result = (result + dp[onesLeft][zerosLeft - len][1]) % MOD;
                }
                dp[onesLeft][zerosLeft][0] = result;
            }
        }

        int start_with_0 = dp[one][zero][0];
        int start_with_1 = dp[one][zero][1];

        return (start_with_0 + start_with_1) % MOD;    
    }
}
