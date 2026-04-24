// Sliding Window
// TC: O(n²)
// SC: O(n)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        List<Character> list = new ArrayList<>();

        int i = 0, j = 0;
        int max = 0;

        while(i < n) {

            if(!list.contains(s.charAt(i))) {
                
                list.add(s.charAt(i));
                max = Math.max(max, list.size());
                i++;

            } else {

                list.remove(Character.valueOf(s.charAt(j)));
                j++;
            }
        }

        return max;
    }
}