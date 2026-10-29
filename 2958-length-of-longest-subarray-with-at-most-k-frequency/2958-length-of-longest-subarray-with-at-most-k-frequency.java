// Time: O(n) — each pointer moves forward at most n times.
// Space: O(n) — the HashMap can store up to n distinct elements.

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        
        int i = 0, j = 0;
        int subArray = 0;
        int maxSubArray = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        while(j < n) {

            int curr = nums[j];
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            while(map.get(curr) > k) {

                int prev = nums[i];
                map.put(prev, map.get(prev) - 1);

                i++;
            }

            subArray = (j - i + 1);
            maxSubArray = Math.max(subArray, maxSubArray);
            j++;
        }

        return maxSubArray;
    }
}