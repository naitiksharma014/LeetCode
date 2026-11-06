// Time: (O(2^n * n) approximately.
// Auxiliary space: O(n), excluding output.

class Solution {
    int n;
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public void solve(int i, int prev, int[] nums) {
        if(i == n) {
            if(list.size() > 1) {
                res.add(new ArrayList<>(list));
            }
            return;
        }

        if(prev <= nums[i]) {

            list.add(nums[i]);

            solve(i + 1, nums[i], nums);

            list.remove(list.size() - 1);
        } 
        
        solve(i + 1, prev, nums);
    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;

        solve(0, Integer.MIN_VALUE, nums);

        res = new ArrayList<>(new LinkedHashSet<>(res));    // Removes Duplicate
        return res;
    }
}