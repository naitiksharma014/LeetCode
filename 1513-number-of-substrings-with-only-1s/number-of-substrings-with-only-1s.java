-------------------------------------------------------------- ( Approach - 1 )-------------------------------------------------------------------------------------------------------------------------------
    
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





-------------------------------------------------------------- ( Approach - 2 )-------------------------------------------------------------------------------------------------------------------------------


class Solution {
    public int numSub(String s) {
        int M = 1000000007;
        long count = 0;
        long res = 0;

        for(char ch : s.toCharArray()){

            if(ch == '1') count++;
            else{
                res = (res + (count * (count + 1)) / 2) % M;
                count = 0;
            }
        }

        res = (res + (count * (count + 1) / 2)) % M;

        return (int) res;
    }
}

 
