//--------------------------------------------------------------------(APPROACH-1)-------------------------------------------------------------------
// Better Approach
// ⏱️ TC: O(4 * n)
// 💾 SC: O(1)

class Solution {
    public void sortColors(int[] nums) {
        int i=0,j=0,k=0;
        

        for(int l=0;l<nums.length;l++){
            if(nums[l]==0)i++;
            else if(nums[l]==1)j++;
            else k++;
        }

        for(int l=0;l<i;l++){
            nums[l]=0;
        }
         for(int l=i;l<i+j;l++){
            nums[l]=1;
        }
         for(int l=i+j;l<i+j+k;l++){
            nums[l]=2;
        }
        // Arrays.sort(nums);

       
        
    }
}


//--------------------------------------------------------------------(APPROACH-2)-------------------------------------------------------------------
// Optimal: Dutch National Flag (DNF) Algorithm: 3 Pointer Approach
// ⏱️ TC: O(n)
// 💾 SC: O(1)

class Solution {
    
    public void swap(int[] nums, int a, int b) {
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }

    public void sortColors(int[] nums) {
        int n = nums.length;
        int low = 0;
        int mid = 0;
        int high = n - 1;

        while(mid <= high) {

            if(nums[mid] == 0) {
                swap(nums, mid, low);
                mid++;
                low++;
            }

            else if(nums[mid] == 1) {
                mid++;
            }

            else {
                swap(nums, mid, high);
                mid++;
                high--;
            }
        }
    }
}
