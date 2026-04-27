//---------------------------------------------------------(Approach - 2)---------------------------------------------------------------------------------------------
// Brute Force
// TC: O(n²)
// SC: O(1)

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++) {

            int sum = 0;

            for(int j = i; j < n; j++) {

                sum += nums[j];

                if(sum == k) {
                    count++;
                }
            }
        }

        return count;
    }
}



//---------------------------------------------------------(Approach - 2)---------------------------------------------------------------------------------------------
// Optimal
// TC: O(n)
// SC: O(n)

class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;

        for(int num: nums) {

            sum += num;

            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
