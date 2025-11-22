class Solution {
    int n;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public void solve(int[] arr, int tar, int idx){
        if (tar < 0 || idx == n) return;

        if(tar == 0){
            res.add(new ArrayList<>(temp));
            return;
        }

       //Option 1 : Take
       temp.add(arr[idx]);                     // Add
       solve(arr, tar - arr[idx], idx);    //Explore
       temp.remove(temp.size() - 1);           //Backtracking
        

        //Option 2 : Skip
        solve(arr, tar, idx + 1);

    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        n = candidates.length;

        solve(candidates, target, 0);

        return res;
    }
}