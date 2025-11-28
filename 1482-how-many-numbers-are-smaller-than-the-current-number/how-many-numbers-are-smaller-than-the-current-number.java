class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] result = nums.clone();
        HashMap<Integer, Integer> map = new HashMap<>();

        Arrays.sort(result);

        for(int i = 0; i < n; i++){
            map.putIfAbsent(result[i], i);
        }

        for(int i=0; i<n; i++){
           result[i] = map.get(nums[i]);
        }
        return result;
    }
}