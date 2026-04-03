// ⏱️ TC: O(m × n)
// 💾 SC: O(m × n) 

class Solution {
    int m, n;
    Integer[][] dp = new Integer[501][501];

    public int solve(String s1, String s2, int i, int j) {
        if(i == m) {
            return n - j;   // insert in s1 (s1 = abc ; s2 = abcd)
        }
        else if(j == n) {
            return m - i;   // delete from s1 (s1 = abcde ; s2 = abc)
        }

        if(dp[i][j] != null) {
            return dp[i][j];
        }


        if(s1.charAt(i) == s2.charAt(j)) {

            return solve(s1, s2, i + 1, j + 1);

        } else {

            int insert = 1 + solve(s1, s2, i, j + 1);
            int delete = 1 + solve(s1, s2, i + 1, j);
            int replace = 1 + solve(s1, s2, i + 1, j + 1);

            return dp[i][j] = Math.min(insert, Math.min(delete, replace));
        }

    }
    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();

        return solve(word1, word2, 0, 0);
    }
}