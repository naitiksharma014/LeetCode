// TC: O(n)
// SC: O(n)

class Solution {
    public boolean isPalindrome(String s) {
        String cleanedString = s.replaceAll("[^a-z0-9A-Z]", "").toLowerCase();
        int l = 0, r = cleanedString.length() - 1;
        
        while(l < r) {
            if(cleanedString.charAt(l) != cleanedString.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}