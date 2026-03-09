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