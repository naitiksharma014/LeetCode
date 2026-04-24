// Sliding Window + Hashmap
// TC: O(n)
// SC: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        int max = 0;

        while(i < n) {
            char c = s.charAt(i);

            if(map.containsKey(c)) {
                
               j = Math.max(j, map.get(c) + 1);
            }

            map.put(c, i);
            max = Math.max(max, i - j + 1);
            i++;
        }

        return max;
    }
}