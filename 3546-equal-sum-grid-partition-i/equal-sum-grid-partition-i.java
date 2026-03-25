// Time: O(m × n) ⚡
// Space: O(m + n) 📦

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long rowSum[] = new long[m];
        long colSum[] = new long[n];
        long total = 0;

        // compute sums
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                total += (long) grid[i][j];

                rowSum[i] += (long) grid[i][j];

                colSum[j] += (long) grid[i][j];
            }
        }

        // if total is odd → impossible
        if(total % 2 != 0) {
            return false;
        }

        // check horizontal cut
        long upper = 0;
        for(int i = 0; i < m; i++) {
            upper += rowSum[i];

            if(upper == total - upper) {
                return true;
            }
        }

        // check vertical cut
        long lower = 0;
        for(int j = 0; j < n; j++) {
            lower += colSum[j];
            if(lower == total - lower) {
                return true;
            }
        }

        return false;
    }
}