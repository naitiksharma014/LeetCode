// TC: O(n * k)
// SC: O(2ᵏ * k)

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();

        int uniqueSub = 1 << k;
        Set<String> set = new HashSet<>();

        for(int i = k; i <= n; i++){

            String sub = s.substring(i - k, i);

            if(!set.contains(sub)){
                set.add(sub);
                uniqueSub--;
            }

            if(uniqueSub == 0) return true;
        }

        return false;
    }
}