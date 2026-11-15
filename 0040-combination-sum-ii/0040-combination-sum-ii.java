class Solution {
    int n;
    Set<Integer> set = new HashSet<>();
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
            
            if(i > idx && candidates[i] == candidates[i - 1]) {
    continue;
}

            currList.add(candidates[i]);

            solve(i + 1, sum + candidates[i], candidates, target);

            currList.remove(currList.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        n = candidates.length;
        Arrays.sort(candidates);

        solve(0, 0, candidates, target);
        return resultList;
    }
}