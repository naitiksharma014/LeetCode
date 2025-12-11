class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        
        int i = n-1;

        while(i >= 0 && s.charAt(i) == ' ') i--;

        int j = i;
        while(i >= 0){
            if(s.charAt(i) == ' '){
                break;
            }
            i--;
        }
        return j-i;
    }
}