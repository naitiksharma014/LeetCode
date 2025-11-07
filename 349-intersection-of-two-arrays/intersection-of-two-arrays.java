class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        
        for(int i = 0; i < n; i++){
            if(set.contains(nums1[i])){
                continue;
            }
           set.add(nums1[i]);
        }
        for(int i = 0; i < m; i++){
            if(set.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }

        int[] arr = new int[res.size()];
        int i = 0;
        for(int num : res){
            arr[i++] = num;
        }
        return arr;
    }
}