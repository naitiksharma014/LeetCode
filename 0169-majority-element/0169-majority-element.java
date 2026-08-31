// TC: (n)

class Solution {
    public int majorityElement(int[] nums) {
        int freq = 0, currNum = 0;

        for(int num: nums) {

            if(freq == 0) {
                currNum = num;
            }

            if(currNum == num) {
                freq++;
            } else {
                freq--;
            }
        }

        return currNum;
    }
}