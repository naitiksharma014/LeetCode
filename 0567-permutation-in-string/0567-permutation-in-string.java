// Time: O(26 * m) = O(m)
// Space: O(26) = O(1)

class Solution {
    int n, m;

    public boolean match(int[] f1, int[] f2) {
        for(int i = 0; i < 26; i++) {
            if(f1[i] != f2[i]) {
                return false;
            }
        }

        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        n = s1.length();
        m = s2.length();

        if (n > m) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for(int i = 0; i < n; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        if(match(freq1, freq2)) {
            return true;
        }

        for(int i = n; i < m; i++) {
            freq2[s2.charAt(i) - 'a']++;
            freq2[s2.charAt(i - n) - 'a']--;

            if(match(freq1, freq2)) {
                return true;
            }
        }
        
        return false;   
    }
}