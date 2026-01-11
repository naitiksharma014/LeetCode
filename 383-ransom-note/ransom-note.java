class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int m = ransomNote.length();
        int n = magazine.length();

        int[] count = new int[26];

        for(int i = 0; i < n; i++){

            char ch = magazine.charAt(i);
            count[ch - 'a']++;
        }

        for(int i = 0; i < m; i++){

            char ch = ransomNote.charAt(i);
            count[ch - 'a']--;

            if(count[ch - 'a'] < 0) return false;
        }
        
        return true;
    }
}