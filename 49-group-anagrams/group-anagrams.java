class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;

        Map<String , List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] ch = str.toCharArray();
            Arrays.sort(ch);

            String sortStr = new String(ch);

            if(!map.containsKey(sortStr)){
                map.put(sortStr , new ArrayList<>());
            }

            map.get(sortStr).add(str);
        }

        return new ArrayList<>(map.values());
    }
}