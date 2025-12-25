class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int n = happiness.length;
        
        Arrays.sort(happiness);
        int count = 0;
        long ans = 0;

        int i = n - 1;
        while(k > 0 && i >= 0){
           
            
            ans += Math.max(0, happiness[i] - count);


            count++;
            k--;
            i--;
        }

        return ans;    
    }
}