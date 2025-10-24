class Solution {
    public boolean solve(int n){
        int[] mp = new int[10];

        while(n > 0){

            int digit = n % 10;
            mp[digit]++;
            n = n / 10;

        }

        for(int i = 0 ; i < 10 ; i++){

            if(mp[i] != 0 && mp[i] != i){
                return false;
            }
        }

        return true;
    }

    public int nextBeautifulNumber(int n) {
        
        for(int i = n + 1 ; i <= 1224444 ; i++){
            
            if(solve(i)){
                return i;
            }

        }

        return 0;

    }
}