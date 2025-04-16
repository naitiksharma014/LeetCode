import java.util.HashMap;

class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0;
        long result = 0;
        long pairs = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while (j < n) {
            int count = map.getOrDefault(nums[j], 0);
            pairs += count;
            map.put(nums[j], count + 1);

            while (pairs >= k) {
                result += n - j;
                int freq = map.get(nums[i]);
                pairs -= freq - 1;
                if (freq == 1) {
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], freq - 1);
                }
                i++;
            }

            j++;
        }

        return result;
    }
}
