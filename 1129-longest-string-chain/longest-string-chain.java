class Solution {
    int n;
    int[][] dp;

    boolean isPredecessor(String s1, String s2){
        if(s2.length() - s1.length() != 1) return false;

        int i = 0, j = 0;

        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)) i++;

            j++;
        }

        if(i == s1.length()) return true;
        return false;
    }
    public int solve(String[] words, int prev_idx, int curr_idx){
        if(curr_idx >= n) return 0;

        if(prev_idx != -1 && dp[curr_idx][prev_idx] != -1){
           return dp[curr_idx][prev_idx];
        }

        int take = 0;
        if(prev_idx == -1 || isPredecessor(words[prev_idx], words[curr_idx])){
            take = 1 + solve(words, curr_idx, curr_idx + 1);
        }

        int skip = solve(words, prev_idx, curr_idx + 1);

        if(prev_idx != -1){
           return dp[curr_idx][prev_idx] = Math.max(take, skip);
        }

        return Math.max(take, skip);
    }
    public int longestStrChain(String[] words) {
        n = words.length;
        
        dp = new int[1001][1001];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        return solve(words, -1, 0);
    }
}