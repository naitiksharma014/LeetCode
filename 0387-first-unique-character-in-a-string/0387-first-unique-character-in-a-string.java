// TC: O(n)
// SC: O(n)

class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        
        int[] freq = new int[26];
        for(char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(int i = 0; i < n; i++) {
            
            char ch = s.charAt(i);
            if(freq[ch - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}