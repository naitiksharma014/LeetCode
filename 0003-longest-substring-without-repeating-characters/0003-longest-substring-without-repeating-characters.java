// Sliding Window + HashSet
// TC: O(n)
// SC: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();

        int i = 0, j = 0;
        int max = 0;

        while(i < n) {

            if(!set.contains(s.charAt(i))) {
                
                set.add(s.charAt(i));
                max = Math.max(max, set.size());
                i++;

            } else {

                set.remove(s.charAt(j));
                j++;
            }
        }

        return max;
    }
}