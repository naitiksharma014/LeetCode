class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer , Integer> map = new HashMap<>();

        for(int i = 0 ; i < n ; i++){
            int remaining = target - nums[i];

            if(map.containsKey(remaining)){
                return new int[] {map.get(remaining) , i};
            }

            map.put(nums[i] , i);
        }

        return new int[] {};
    }
}