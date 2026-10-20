// Sliding Window
// TC: O(n)
// Sc: O(n)

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;

        int i = 0, j = 0;
        Set<Integer> set = new HashSet<>();

        while(j < n) {

            if(Math.abs(i - j) > k) {

                int prevNum = nums[i];
                set.remove(prevNum);
                i++;
            }

            int currNum = nums[j];
            if(set.contains(currNum)) {
                return true;
            }

            set.add(currNum);
            j++;
        }

        return false;
    }
}