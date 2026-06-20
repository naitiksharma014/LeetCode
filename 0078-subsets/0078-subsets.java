// Time Complexity: O(2ⁿ · n) 
// Space Complexity: O(2^n*length of each subset) to store each subset 

// The recursion stack space complexity is O(N) , the maximum depth of the recursion is N, where N is the length of the input array.

class Solution {

    int n;
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public void solve(int[] nums, int idx) {
        if(idx == n) {
            result.add(new ArrayList<>(list));
            return;
        }


        // Take
        list.add(nums[idx]);
        solve(nums, idx + 1);
        list.remove(list.size() - 1);

        // Skip
        solve(nums, idx + 1);
    }

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;

        solve(nums, 0);

        return result;
    }
}