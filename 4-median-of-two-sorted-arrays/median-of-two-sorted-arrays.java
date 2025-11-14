class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] nums = new int[m+n];

        int i = 0, j = 0, k = 0;
        while(i < m && j < n){

            if(nums1[i] < nums2[j]){
                nums[k++] = nums1[i++];
            }
            else{
                nums[k++] = nums2[j++];
            }
        }

        while(i < m) nums[k++] = nums1[i++];
        while(j < n) nums[k++] = nums2[j++];

        int l = nums.length;
        int mid = l/2;
        if(l % 2 != 0) return (float)nums[mid];
        return (float)(nums[mid] + nums[mid - 1])/2;
    }
}