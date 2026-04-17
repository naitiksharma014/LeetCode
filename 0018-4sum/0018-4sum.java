// 🧠 Sorting + Two Pointer Approach
// ⏱️ TC: O(n³)
// 💾 SC: O(1)

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < n - 3; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < n - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                long remainTarget = (long) target - nums[i] - nums[j];

                while(left < right) {
                    long sum = (long) nums[left] + nums[right];

                    if(sum > remainTarget) {
                        right--;

                    } else if(sum < remainTarget) {
                        left++;

                    } else {

                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        int lastLeft = nums[left];
                        int lastRight = nums[right];

                        left++;
                        right--;

                        while(left < right && nums[left] == lastLeft) left++;
                        while(left < right && nums[right] == lastRight) right--;
                    }
                }
            }
        }
        return result; 
    }
}