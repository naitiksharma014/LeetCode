// TC: O(n)
// SC: O(K)

class Solution {
    public int slidingWindow(int[] nums, int k) {
        int n = nums.length;

        int i = 0;
        int j = 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while(j < n){

            int curr = nums[j];
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            while(map.size() > k) {

                int prev = nums[i];
                map.put(prev, map.get(prev) - 1);

                if(map.get(prev) == 0) {
                    map.remove(prev);
                }

                i++;
            }

            count += (j - i + 1);
            j++;
        }

        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        // Exactly K distinct → AtMost(K) - AtMost(K-1)

        int AtMost_K = slidingWindow(nums, k);
        int AtMost_K_minus_1 = slidingWindow(nums, k - 1);
        int Exactly_K_distinct =  AtMost_K - AtMost_K_minus_1;

        return Exactly_K_distinct;
    }
}