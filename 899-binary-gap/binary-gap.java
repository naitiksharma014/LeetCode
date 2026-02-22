// TC: O(log n) 
// SC: O(1)

class Solution {
    public int binaryGap(int n){
        
        int gap = 0;
        int curr = 0;
        int prev = -1;

        while(n > 0){

            int currBit = (n & 1);   // check current (rightmost) bit

            if(currBit == 1){
               
                if (prev != -1) {
                    gap = Math.max(gap, curr - prev);
                }
               
                prev = curr;
            }

            n = n >> 1;
            curr++;
        }

        return gap;
    }
}