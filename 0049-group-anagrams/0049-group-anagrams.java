// TC: O(n⋅klogk)   n = number of strings, k = maximum string length
// SC: O(n⋅k)

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, ArrayList<String>> map = new HashMap<>();

        for(String str: strs) {

            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            String newStrs = new String(ch);

            map.putIfAbsent(newStrs, new ArrayList<>());
            map.get(newStrs).add(str);
        }

        return new ArrayList<>(map.values());
    }
}