class Solution {
    int MOD = 1000000007;

    public boolean isPowerOf2(int num){
        // Check power of 2
        return (num & (num - 1)) == 0;
    }

    public int concatenatedBinary(int n) {
        long res = 0;
        int digit = 0;

        for(int i = 1; i <= n; i++){

            if(isPowerOf2(i)){
                digit++;
            }

            res = ((res << digit) % MOD + i) % MOD;
        }

        return (int) res;
    }
}