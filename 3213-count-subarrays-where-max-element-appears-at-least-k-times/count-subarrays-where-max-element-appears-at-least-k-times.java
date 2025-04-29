class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n=nums.length;
        int i=0,j=0;
        int countMax=0;
        long result=0;

        int maxVal = Arrays.stream(nums).max().getAsInt();

   
       

        while(j<n){
            if(nums[j]==maxVal) countMax++;

            while(countMax>=k){
                result+=n-j;

                if(nums[i]==maxVal) countMax--;
                i++;
            }
            j++;
        }
        return result;

    }
}