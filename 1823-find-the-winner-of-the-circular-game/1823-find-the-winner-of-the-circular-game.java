// TC: O(n)

class Solution {
    public int solve(int n, int k) {
        if(n == 1) {
            return 0;
        }

        int idx = solve(n - 1, k);
        idx = (idx + k) % n;

        return idx;
    }

    public int findTheWinner(int n, int k) {
        return solve(n, k) + 1;
    }
}