// Sliding Window + Frequency Array
// TC: O(n + m)
// SC: O(128) ≈ O(1)

class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] freq = new int[128];

        for(char ch: t.toCharArray()){
            freq[ch]++;
        }

        int minLen = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int required = m;
        int start = 0;

        while(right < n){

            char ch = s.charAt(right);

            if(freq[ch] > 0){
                required--;
            }

            freq[ch]--;

            while(required == 0){

                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    start = left;
                }

                char leftCh = s.charAt(left);
                freq[leftCh]++;

                if(freq[leftCh] > 0){
                    required++;
                }

                left++;
            }

            if(required == 0){

                minLen = Math.min(minLen, right - left + 1);
            }

            right++;

        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}