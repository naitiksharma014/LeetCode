// Time Complexity  : O(2^n)
// Space Complexity : O(n) auxiliary

class Solution {
    int n; 
    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public void solve(int[] candidates, int tar, int i) {
        if(tar == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if(i >= n || tar < 0){
            return;
        }


        // Take
        list.add(candidates[i]);
        solve(candidates, tar - candidates[i], i + 1);
        list.remove(list.size() - 1);

        int j = i;      //To Handle Duplicate Values

        while(j + 1 < n && candidates[j] == candidates[j + 1]) {
            j++;
        }

        //Skip
        solve(candidates, tar, j + 1);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        n = candidates.length;

        Arrays.sort(candidates);

        solve(candidates, target, 0);

        return result;
    }
}