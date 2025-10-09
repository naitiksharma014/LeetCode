class Solution {
    int[] t;
    public int fib(int n) {
        t = new int[n + 1];
        for(int i = 0 ; i <= n ; i++){
            t[i] = -1;
        }

        if(n == 0 || n == 1) return n;

        if(t[n] != -1) return t[n];
        return t[n] = fib(n - 1) + fib(n - 2);
    }
}