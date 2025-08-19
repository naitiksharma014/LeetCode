class Solution {
    public long zeroFilledSubarray(int[] nums) {
       int n = nums.length;
       int i = 0;
       long res = 0 , l = 0; // l : zeroes

       while( i < n ){
            l = 0;
           if(nums[i] == 0){
              
              while(i < n && nums[i] == 0){
                l++;
                i++;
              }
            }

            else{
                
                i++;
            }

            res += l * (l + 1) / 2;
        } 
        return res;
    }
}