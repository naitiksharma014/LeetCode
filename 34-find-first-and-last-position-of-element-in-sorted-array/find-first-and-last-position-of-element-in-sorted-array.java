class Solution {
    public int fOccurance(int[] nums , int target){
        int n = nums.length;
        int s=0 , e=n-1;
        int idx=-1;

        while(s<=e){
            int mid=s+(e-s)/2;
            
           
            if(nums[mid] == target){
                idx=mid;
                e=mid-1;
            }

            else if(nums[mid] < target) s=mid+1;
            else e=mid-1;

        }
        return idx;
    }
    public int eOccurance(int[] nums , int target){
        int n = nums.length;
        int s=0 , e=n-1;
        int idx=-1;

        while(s<=e){
            int mid=s+(e-s)/2;
            
            
            if(nums[mid] == target){
                idx=mid;
                s=mid+1;
            }

            else if(nums[mid] < target) s=mid+1;
            else e=mid-1;

        }
        return idx;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];

        res[0] = fOccurance(nums , target);
        res[1] = eOccurance(nums, target);

        return res;
    }
}
    