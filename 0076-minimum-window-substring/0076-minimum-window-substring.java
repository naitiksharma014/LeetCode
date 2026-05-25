// Sliding Window + Frequency Array
// TC: O(n + m)
// SC: O(128) ≈ O(1)

class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(n > m) {
            return "";
        }

        int[] freq = new int[128];
        for(char ch: t.toCharArray()) {
            freq[ch]++;
        }

        int minWindowSize = Integer.MAX_VALUE;
        int required = n;
        int i = 0, j = 0;
        int start_i = 0;

        while(j < m) {

            if(freq[s.charAt(j)] > 0) {
                required--;
            }

            freq[s.charAt(j)]--;

            while(required == 0) {
                // Shrink the window
                int currWindowSize = j - i + 1;

                if(minWindowSize > currWindowSize) {
                    minWindowSize = currWindowSize;
                    start_i = i; 
                }
                
                freq[s.charAt(i)]++;

                if(freq[s.charAt(i)] > 0) {
                    required++;
                }

                i++;
            }

            j++;
        }

        return minWindowSize == Integer.MAX_VALUE ? "" : s.substring(start_i, start_i + minWindowSize);
    }
}