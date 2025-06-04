class Solution {

    public int gcd(int a, int b){
        // int result = Math.min(a,b);

       while (b != 0) {
            var tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;

    }

    public String gcdOfStrings(String str1, String str2) {
        
        if((str1 + str2).equals(str2 + str1)){
            int gcd = gcd(str1.length(),str2.length());
            return str1.substring(0,gcd);
        }

        else {
            return "";
        }    
    }
}