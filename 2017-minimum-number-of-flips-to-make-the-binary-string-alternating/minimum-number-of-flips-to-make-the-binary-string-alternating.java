// TC: O(2n) = O(n)
// SC: O(1)

class Solution {
    public int minFlips(String s) {
        int n = s.length();

        // Two New Alternating String Starting with 1 and 0
        // s1: 010101010101  odd -> 1 and even -> 0
        // s2: 101010101010  odd -> 0 and even -> 1

        int result = Integer.MAX_VALUE;
        int flip1 = 0, flip2 = 0;
        int left = 0, right = 0;

        while(right < 2 * n){

            if(s.charAt(right % n) != (right % 2 == 0 ? '0' : '1')){
                flip1++;
            }

            if(s.charAt(right % n) != (right % 2 == 0 ? '1' : '0')){
                flip2++;
            }

            //Shrink the window
            while(right - left + 1 > n){
                  
                if(s.charAt(left % n) != (left % 2 == 0 ? '0' : '1')){
                    flip1--;
                }

                if(s.charAt(left % n) != (left % 2 == 0 ? '1' : '0')){
                    flip2--;
                }

                left++;
            }
            
            // Valid Window
            if(right - left + 1 == n){
                result = Math.min(result, Math.min(flip1, flip2));
            }

            right++;
        }

        return result;
    }
}