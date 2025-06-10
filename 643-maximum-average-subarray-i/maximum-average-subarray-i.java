class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int curr = 0;
        
        //S1 First Window Calculate
        for(int i=0 ; i<k ; i++){
            curr += nums[i];
        }
        int avg = curr;

        //S2: Other Window Calcu;ate
        for(int i=1 ; i<=n-k ; i++){
            curr = curr - nums[i-1] + nums[i+k-1];
            if(avg < curr){
                avg = curr;
            }
            
        }
        return (double) avg / k;
    }
}