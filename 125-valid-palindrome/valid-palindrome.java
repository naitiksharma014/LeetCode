class Solution {
    public boolean isPalindrome(String s) {
        String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int n = cleanedString.length();
        int l = 0 , r = n-1;
    
        while( l <= r ){
            if( cleanedString.charAt(l) != cleanedString.charAt(r) ){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}