// TC: O(n)
// SC: O(n)

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        for(int num: nums1) {
            set1.add(num);
        }

        for(int num: nums2) {
            if(set1.contains(num)) {
                set2.add(num);
            }
        }

        int[] result = new int[set2.size()];
        int i = 0;

        for (int num: set2) {
            result[i++] = num;
        }

        return result;
    }
}