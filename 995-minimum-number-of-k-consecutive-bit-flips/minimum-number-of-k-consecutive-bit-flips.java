// TC: O(n)
// SC: O(n)

class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;

        boolean[] isFlipped = new boolean[n];
        int flip = 0;
        int flipCountBefore = 0;

        for(int i = 0; i < n; i++){
               
            if(i >= k && isFlipped[i - k] == true){
                flipCountBefore--;
            }

            if(flipCountBefore % 2 == nums[i]){

                if(i + k > n){
                    return -1;
                }

                flipCountBefore++;
                flip++;
                isFlipped[i] = true;
            }

        }

        return flip;
    }
}