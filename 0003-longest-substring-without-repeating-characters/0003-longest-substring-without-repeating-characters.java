// Time: O(n)
// Space: O(min(n, charset))

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0, left = 0;
        Set<Character> set = new HashSet<>();

        for(int right = 0; right < n; right++) {

            char ch = s.charAt(right);

            while(set.contains(ch)) {
                char leftCh = s.charAt(left);
                set.remove(leftCh);
                left++;
            }

            set.add(ch);
            maxLen = Math.max(maxLen, set.size());
        }

        return maxLen;
    }
}