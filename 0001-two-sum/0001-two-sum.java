// TC: O(n)
// Sc: O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {

            int first = nums[i];
            int second = target - first;

            if(map.containsKey(second)) {
                ans[0] = i;
                ans[1] = map.get(second);
            }

            map.put(first, i);
        }

        return ans;
    }
}