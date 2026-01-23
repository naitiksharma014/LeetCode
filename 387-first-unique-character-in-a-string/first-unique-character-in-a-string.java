class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        int[] map = new int[26];

        for(char ch : s.toCharArray()){
            map[ch - 'a']++;
        }
        
        int index = -1;
        for(int i = 0; i < n; i++){
            
            char ch = s.charAt(i);

            if(map[ch - 'a'] == 1){
                index = i;
                break;
            }
        }

        return index;
    }
}