// Time Complexity: O(N × M)
//     N = number of strings
//     M = shortest string length
// Space Complexity: O(1)

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;

        if(strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for(int i = 1; i < n; i++) {

            while(!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);

                if(prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}