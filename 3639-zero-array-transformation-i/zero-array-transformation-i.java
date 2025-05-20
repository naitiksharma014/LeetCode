class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        

        //Step 1: Make Difference Array
        int diff[]=new int[n];
        for (int[] query : queries){
            int start=query[0];
            int end=query[1];
            int x=1;

            diff[start]+=x;
            if(end+1<n){
                diff[end+1]-=x;
            
            }
            
        }


        //Step 2: Result Array
        int result[]=new int[n];
        int currSum=0;
        for(int i=0;i<n;i++){
            currSum+=diff[i];
            result[i]=currSum;
          
        }

        
        //Step 3: Check
        for(int i=0;i<n;i++){
            if(nums[i]>result[i])return false;
        }
        return true;
        
    }
}