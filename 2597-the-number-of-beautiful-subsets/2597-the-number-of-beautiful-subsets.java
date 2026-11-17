// Time Complexity: O(n * 2ⁿ)
// Space Complexity: O(n)

class Solution {
    int n;
    int result = 0;

    public void solve(int idx, int[] nums, int k, List<Integer> list) {
        if(idx >= n) {
            result++;
            return;
        }

        // Skip
        solve(idx + 1, nums, k, list);

        // Take
        boolean isPresent = true;

        for(int num: list) {

            if(Math.abs(num - nums[idx]) == k) {
                isPresent = false;
                break;
            }
        }

        if(isPresent) {

            list.add(nums[idx]);

            solve(idx + 1, nums, k, list);

            list.remove(list.size() - 1);
        }
    }

    public int beautifulSubsets(int[] nums, int k) {
        n = nums.length;
        
        solve(0, nums, k, new ArrayList<>());

        return result - 1;  // Remove empty subset
    }
}