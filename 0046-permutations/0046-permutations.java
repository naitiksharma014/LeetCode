// TC: O(N * N!)
// SC: O(N) auxiliary, excluding output.

class Solution {
    int n;
    Set<Integer> set = new HashSet();
    List<Integer> currList = new ArrayList<>();
    List<List<Integer>> resultList = new ArrayList<>();

    public void solve(int idx, int[] nums){
        if(currList.size() == n) {
            resultList.add(new ArrayList<>(currList));
            return;
        }

        for(int i = 0; i < n; i++) {

            if(set.contains(nums[i])) {
                continue;
            }

            set.add(nums[i]);
            currList.add(nums[i]);

            solve(i, nums);

            set.remove(nums[i]);
            currList.remove(currList.size() - 1);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;

        solve(0, nums);
        return resultList;
    }
}