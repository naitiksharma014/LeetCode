class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> solve(int[] arr, int k, int n, int i){
        if (k < 0 || n < 0) {
            return res;
        }

        if(k == 0 && n == 0){
           res.add(new ArrayList<>(temp));
            return res;
        }

        if(i >= arr.length) return res;

        //Take
        temp.add(arr[i]);
        solve(arr, k-1, n-arr[i], i+1);
        temp.remove(temp.size()-1);


        //Skip
        solve(arr, k, n, i+1);

        return res;
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = {1,2,3,4,5,6,7,8,9};

        return solve(arr, k, n, 0);
    }
}