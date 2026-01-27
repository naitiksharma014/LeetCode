class Solution {
    int n;
    HashSet<Integer> set = new HashSet<>();
    List<List<Integer>> result = new ArrayList<>();

    public void solve(int[] nums, ArrayList<Integer> temp){
        if(temp.size() == n){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < n; i++){

            if(!set.contains(nums[i])){

                // Add
                set.add(nums[i]);
                temp.add(nums[i]);

                //Explore
                solve(nums, temp);

                // Backtrack
                set.remove(nums[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;

        solve(nums, new ArrayList<Integer>());

        return result;
    }
}