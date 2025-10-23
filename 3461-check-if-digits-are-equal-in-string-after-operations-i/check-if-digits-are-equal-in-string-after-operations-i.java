class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);

        while(n > 2){
           
           for(int i = 0 ; i < n - 1 ; i++){
                 
                int sum = (sb.charAt(i) - '0' + sb.charAt(i + 1) - '0') % 10;
                sb.setCharAt( i , (char)(sum + '0') );

            }
            n--;

        }

        return sb.charAt(0) == sb.charAt(1);
    }
}