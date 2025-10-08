class Solution {
    int[] t;
    public int solve(int i , int n , int[] t){
        if(i == n) return 1;
        if(i > n) return 0;
        
        if(t[i] != -1) return t[i];

        int oneStep = solve(i + 1 , n , t);
        int twoStep = solve(i + 2 , n , t);

        return t[i] = oneStep + twoStep;
    }
    public int climbStairs(int n) {
        t = new int[n + 1];
        for(int i = 0 ; i < n + 1 ; i++){
            t[i] = -1;
        }

        return solve(0 , n , t);
    }
}