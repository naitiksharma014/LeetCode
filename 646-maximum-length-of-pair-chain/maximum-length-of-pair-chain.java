class Solution {
    int n;
    int[][] dp;

    public int solve(int[][] pairs, int curr_idx, int prev_idx){
        if(curr_idx >= n) return 0;

        
        if(prev_idx != -1 && dp[curr_idx][prev_idx] != -1){
            return dp[curr_idx][prev_idx];
        }


        int take = 0;
        if(prev_idx == -1 || pairs[prev_idx][1] < pairs[curr_idx][0]){
            take = 1 + solve(pairs, curr_idx+1, curr_idx);
        }

        int skip = solve(pairs, curr_idx+1, prev_idx);

        if(prev_idx != -1){
            dp[curr_idx][prev_idx] = Math.max(take, skip);
        }

        return Math.max(take, skip);
    }
    public int findLongestChain(int[][] pairs) {
        n = pairs.length;

        dp = new int[1001][1001];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }  

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));

        return solve(pairs, 0, -1);
    }
}