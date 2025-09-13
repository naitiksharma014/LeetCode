class Solution {
    public boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch =='i' || ch == 'o' || ch =='u') return true;
        return false;
    }
    public int maxFreqSum(String s) {
       int n = s.length();
       
       int[] map = new int[26];

       for(int i = 0 ; i < n ; i++){
           char ch = s.charAt(i);
           map[ch - 'a']++;
        }

        int maxVol = 0 , maxCon = 0;

        for(int i = 0 ; i < 26 ; i++){
            char ch = (char) (i + 'a');
            if(isVowel(ch) ){
                maxVol = Math.max(maxVol , map[i]);
            }
            else{
                maxCon = Math.max(maxCon , map[i]);
            }
        }
        System.out.println(maxVol);
        return (maxVol + maxCon);
    }
}