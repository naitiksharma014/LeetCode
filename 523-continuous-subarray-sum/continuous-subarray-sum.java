class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // remainder -> index
        int sum = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++){

            sum += nums[i];

            int rem = sum % k;

            if(map.containsKey(rem)){
                if(i - map.get(rem) > 1) return true;
            }
            else{
                map.put(rem , i);
            }
        }

        return false;
    }
}