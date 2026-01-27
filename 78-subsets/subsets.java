class Solution {
    int n;
    List<List<Integer>> result = new ArrayList<>();

    public void solve(int i, int[] nums, ArrayList<Integer> list){
        if(i == n){
            result.add(new ArrayList<>(list));
            return;
        }
         
        // Take
        list.add(nums[i]);
        solve(i + 1, nums, list);

        // Backtrack
        list.remove(list.size() - 1);

        // Skip
        solve(i + 1, nums, list);
    }
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;

        solve(0, nums, new ArrayList<Integer>());

        return result;
    }
}