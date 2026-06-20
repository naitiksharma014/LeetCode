// TC: O(n log n + 2ⁿ · n) = O(2ⁿ · n)
// Auxiliary Space: O(n)
// Output Space: O(n · 2ⁿ)

class Solution {
    int n;
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public void solve(int[] nums, int idx) {
        if(idx == n) {
            result.add(new ArrayList<>(list));
            return;
        }
        

        
        // Take idx
        list.add(nums[idx]);
        solve(nums, idx + 1);
        list.remove(list.size() - 1);

        
        // Skip current element and all its duplicates
        while(idx + 1 < n && nums[idx] == nums[idx + 1]) {
            idx++;
        }

        // Skip idx
        solve(nums, idx + 1);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);
        
        solve(nums, 0);

        return result;
    }
}