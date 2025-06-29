class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;

        int M = 1000000007;


        int power[] = new int[n];
        power[0] = 1;
        for(int i = 1 ; i<n ; i++){
            power[i] = ( power[i-1] * 2 ) % M;
        }

        int result = 0;

        int lp = 0 , rp = n-1;

        while(lp<=rp){
            if(nums[lp] + nums[rp] <= target){
                result = ( result % M + power[rp - lp] ) % M;
                lp++;
            }
            else rp--;
        }

        return result;
        
    }
}