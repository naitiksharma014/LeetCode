class Solution {
    int n;
    Long[][] t; // Use Long to handle null for memoization (Java doesn't support -1 init for long arrays easily)

    public long solve(int idx, int[] nums, boolean isEven) {
        if (idx >= n) return 0;

        int f = -1;
        if(isEven == false){
            f = 1;
        }
        else{
            f = 0;
        }

        if (t[idx][f] != null) return t[idx][f];

        long skip = solve(idx + 1, nums, isEven); // skip -> isEven is same

        //long val = isEven ? nums[idx] : -nums[idx];
        long val = nums[idx];
        if(isEven == false){
            val = - val;
        }

        long take = val + solve(idx + 1, nums, !isEven);  //take -> isEven changes

        return t[idx][f] = Math.max(skip, take);
    }

    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        t = new Long[n][2]; // Use wrapper Long to allow nulls for memoization
        return solve(0, nums, true);
    }
}
