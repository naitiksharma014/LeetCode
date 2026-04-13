// ⏱️ TC = O(m + n)
// 💾 SC = O(1)

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) {
            return;
        }
        if(m == 0) {
            for(int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        int i = m - 1;
        int j = n - 1;  
        int t = m + n - 1 ;  

        while(i >= 0 && j >= 0) {

            if(nums1[i] <= nums2[j]) {
                nums1[t--] = nums2[j--];
            }
            else if(nums1[i] > nums2[j]) {
                nums1[t--] = nums1[i--];
            }
        }

        while(j >= 0) {
            nums1[t--] = nums2[j--];
        }
    }
}