// TC: O(n)
// SC: O(n)

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();    // num-> idx

        for(int i = 0; i < n; i++) {

            if(map.containsKey(nums[i])) {

                int idx = map.get(nums[i]);

                if(Math.abs(idx - i) <= k) {
                    return true;
                }
            }

            map.put(nums[i], i);
        }

        return false;
    }
}