//--------------------------------------------------------(Approach - 1)-------------------------------------------------------------
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


//--------------------------------------------------------(Approach - 2)-------------------------------------------------------------
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


//--------------------------------------------------------(Approach - 3)-------------------------------------------------------------
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
