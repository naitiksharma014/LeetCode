// Sliding Window + Frequency Array
// TC: O(n + m)
// SC: O(128) ≈ O(1)

class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(m < n) {
            return "";
        }

        int[] freq = new int[128];
        for(char ch: t.toCharArray()) {
            freq[ch]++;
        }

        int minWindow = Integer.MAX_VALUE;
        int requiredCount = n;
        int i = 0, j = 0;
        int start = 0;

        while(j < m) {

            char ch = s.charAt(j);

            if(freq[ch] > 0) {      // Required wala
                requiredCount--;
            }

            freq[ch]--;

            while(requiredCount == 0) {

                int currWindow = j - i + 1;
                
                if(currWindow < minWindow) {
                    minWindow = currWindow;
                    start = i;
                }

                char prevChar = s.charAt(i);
                freq[prevChar]++;

                if(freq[prevChar] > 0) {
                   requiredCount++;
                }

                i++;
            }

            j++;
        }

        return minWindow == Integer.MAX_VALUE ? "" : s.substring(start, start + minWindow);
    }
}