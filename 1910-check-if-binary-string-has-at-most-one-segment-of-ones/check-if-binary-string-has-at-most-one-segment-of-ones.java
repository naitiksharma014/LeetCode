// TC: O(n)

class Solution {
    public boolean checkOnesSegment(String s) {
       int n = s.length();
       int i = 0;

       while(i < n && s.charAt(i) == '1') i++;

       if(i == n) return true;

        for(; i < n; i++){

            if(s.charAt(i) == '1'){
                return false;
            }
        }

        return true;
    }
}