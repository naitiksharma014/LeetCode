class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;       //start from last non zero element of num1
        int j = n - 1;       //start from last element of num2
        int k = m + n - 1;   //start from last element of num1
        
        // merge from last of nums1 and nums2
        while(i >= 0 && j >= 0){

            if(nums1[i] < nums2[j]){
                nums1[k--] = nums2[j--];
            }
            else{
                nums1[k--] = nums1[i--];
            }
        }
        
        //remaining element
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
       
    }

}