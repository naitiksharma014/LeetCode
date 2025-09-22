class Solution {
    public int maxFrequencyElements(int[] nums) {
        int maxFreq = 0;
        int res = 0;
        int[] freq = new int[101];

        for(int num : nums){
            freq[num]++;

            maxFreq = Math.max(maxFreq , freq[num]);
        }

        for(int i = 0 ; i < 101 ; i++){

            if(maxFreq == freq[i]){

                res += maxFreq;
            }
        }

        return res;
    }
}