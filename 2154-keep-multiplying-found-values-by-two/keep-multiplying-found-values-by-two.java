class Solution {
    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            set.add(nums[i]);
        }

        while(set.contains(original)){
            original *= 2;
        }

        return original;
    }
}