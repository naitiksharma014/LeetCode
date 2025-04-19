class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        
    //     int count=0;

    //     for(int i=0;i<nums.length;i++){
    //         for(int j=i+1;j<nums.length;j++){
    //             if(lower<=nums[i]+nums[j]  && nums[i]+nums[j]<=upper){
                    
    //                 count++;
    //             }
                
    //         }
    //     }
    //     return count;
    // }
     
    
      int n=nums.length;
      Arrays.sort(nums);

       long result=0;

       for(int i=0;i<n;i++){
          int leftIdx=lowerBound(nums,i+1,n,lower-nums[i]);
          int rightIdx=upperBound(nums,i+1,n,upper-nums[i]);

           int x=leftIdx-i-1;
           int y=rightIdx-i-1;

           result+=(y-x);
        }
       return result;
    }
     

    public int lowerBound(int nums[],int start, int end, int target){
       while(start<end){
           int mid=(start+end)/2;
           if(nums[mid]<target){
            start=mid+1;
            }
            else{
            end=mid;
            }
        }
        return start;
    }

    public int upperBound(int nums[],int start, int end, int target){
        while(start<end){
            int mid=(start+end)/2;
            if(nums[mid]<=target){
            start=mid+1;
            }
            else{
            end=mid;
             }
        
        
        }
        return start;

    }

}

