// Time: (O(n * 2^n) upper bound.
// Auxiliary space: O(n), excluding output.

class Solution {
    int n;
    List<Integer> currList = new ArrayList<>();
    List<List<Integer>> resultList = new ArrayList<>();
    

    public void solve(int i, int[] nums) {
        if(currList.size() > 1) {
            resultList.add(new ArrayList<>(currList));
        }

        HashSet<Integer> set = new HashSet<>();

        for(int j = i; j < n; j++) {

            if(set.contains(nums[j])) {
                continue;
            }
            
            if(currList.isEmpty() || currList.get(currList.size() - 1) <= nums[j]) {

                set.add(nums[j]);
                currList.add(nums[j]);

                solve(j + 1, nums);

                currList.remove(currList.size() - 1);
            }
        }

    }
    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;

        solve(0, nums);

        return resultList;
    }
}