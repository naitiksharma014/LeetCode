class Solution {
    int n;
    List<Integer> currList = new ArrayList<>();
    List<List<Integer>> resultList = new ArrayList<>();

    public void solve(int idx, int sum, int[] candidates, int target) {
        if(sum == target) {
            resultList.add(new ArrayList<>(currList));
            return;
        }

        if(sum > target) {
            return;
        }

        for(int i = idx; i < n; i++) {

            currList.add(candidates[i]);

            solve(i, sum + candidates[i], candidates, target);

            currList.remove(currList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        n = candidates.length;
        solve(0, 0, candidates, target);

        return resultList;
    }
}