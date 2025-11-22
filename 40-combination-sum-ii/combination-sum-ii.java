class Solution {
    int n;
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public void solve(int[] arr, int target, int i){
        if(target == 0 ){
            res.add(new ArrayList<>(temp));
            return;
        }

        if(i >= n || target < 0) return;

        //Option 1 : Take
        temp.add(arr[i]);
        solve(arr, target - arr[i], i + 1);
        temp.remove(temp.size() - 1);

        //Option 2 : Skip
        int j = i + 1;                    //To Handle Duplicate Values
        while(j < n && arr[i] == arr[j]){
            j++;
        }

        solve(arr, target, j);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        n = candidates.length;

        Arrays.sort(candidates);

        solve(candidates, target, 0);

        return res;
    }
}