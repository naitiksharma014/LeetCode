class Solution {
    public int numSub(String s) {
        int M = 1000000007;
        long count = 0;
        long res = 0;

        for(char ch : s.toCharArray()){

            if(ch == '1'){
                count++;
                res = (res + count) % M;
            }
            else{
                count = 0;
            }
        }

        return (int) res;
    }
}