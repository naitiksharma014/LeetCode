class Solution {

    int n;
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public void solve(int[] candidates, int tar, int i) {
        if(i == n || tar < 0) {
            return;
        }

        if(tar == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        // Take
        list.add(candidates[i]);                        // ADD
        solve(candidates, tar - candidates[i], i);      // Explore
        list.remove(list.size() - 1);                   // Remove

        //Skip
        solve(candidates, tar, i+1);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        n = candidates.length;

        solve(candidates, target, 0);

        return result;
    }
}