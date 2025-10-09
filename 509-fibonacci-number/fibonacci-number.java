class Solution {
    int[] t;
    public int solve(int n , int[] t){
        if(n == 0 || n == 1) return n;

        if(t[n] != -1) return t[n];
        return t[n] = solve(n - 1 , t) + solve(n - 2 , t);
    }

    public int fib(int n) {
        t = new int[n + 1];
        for(int i = 0 ; i <= n ; i++){
            t[i] = -1;
        }

       return solve(n , t);
    }
}