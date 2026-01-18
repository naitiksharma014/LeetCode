class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();

        int[] freqs = new int[128]; // ASCII for A-Z, a-z

        for(char ch : s.toCharArray()){
            freqs[ch]++;
        }

        int len = 0;
        boolean hasOdd = false;

        for(int freq : freqs){
            len += (freq / 2 ) * 2;

            if(freq % 2 != 0) hasOdd = true;
        }
 
        if(hasOdd) len ++;

        return len;
    }
}