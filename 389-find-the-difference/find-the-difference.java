class Solution {
    public char findTheDifference(String s, String t) {
        int result = 0;
        
        // s = abc
        // t = abdc

        for(char ch: s.toCharArray()){
                                        // result ^= a => a
            result  = result ^ ch;      // result ^= b => a^b
        }                               // result ^= c => a^b^c
 
        for(char ch: t.toCharArray()){
                                        // result ^= a => (a^b^c)^a => b^c
            result  = result ^ ch;      // result ^= b => (b^c)^b   => c
                                       // result ^= d => (c)^d     => c^d
        }                              // result ^= c => (c^d)^c   => d

        return (char) result;
    }
}