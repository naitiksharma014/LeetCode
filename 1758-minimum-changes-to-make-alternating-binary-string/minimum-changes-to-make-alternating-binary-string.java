// TC: O(n)
// SC: O(1)

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int count = 0;
        int start_with_0 = 0;  // 0 at even and 1 at odd
        int start_with_1 = 0;  // 1 at even and 0 at odd



        for(int i = 0; i < n; i++){
                
            if(i % 2 == 0){

                if(s.charAt(i) == '0'){
                    start_with_1++;
                } 
                else {
                    start_with_0++;
                }
            }
            else {

                if(s.charAt(i) == '0'){
                    start_with_0++;
                } 
                else {
                    start_with_1++;
                }
            }
        }

        return Math.min(start_with_0, start_with_1);
    }
}