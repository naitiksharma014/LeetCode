// 🧠 Sorting + Two Pointers
// ⏱️ TC: O(n log n) + O(n * n) = O(n²)
// 💾 SC: O(1)

class Solution {
    int n;
    List<List<Integer>> result = new ArrayList<>();

    public void twoSum(int[] nums, int idx, int target) {
        int i = idx;
        int j = n - 1;

        while(i < j) {

            if(nums[i] + nums[j] == target) {

                result.add(Arrays.asList(-target, nums[i], nums[j]));

                while(i < j && nums[i] == nums[i + 1]) i++;
                while(i < j && nums[j] == nums[j - 1]) j--;

                i++;
                j--;

            } else if(nums[i] + nums[j] > target) {
                j--;
            } else {
                i++;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        n = nums.length;

        if(n < 3) return new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < n - 1; i++) {

            if(i != 0 && nums[i] == nums[i - 1]) continue;

            int target = nums[i];
            twoSum(nums,  i + 1, -target);  // a + b + c = 0 => a + b = -c
        }   

        return result;
    }
}