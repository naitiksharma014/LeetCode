// ⏱️ Complexity
// Time: O(m × n)
// Space: O(m × n) (can optimize to O(1) if modifying grid)

class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;     // row
        int n = grid[0].length;  // col

        int[][] prefix = new int[m][n];
        int count = 0;

        for(int i = 0; i < m; i++){
            
            for(int j = 0; j < n; j++){

                prefix[i][j] = grid[i][j];

                if(i > 0) prefix[i][j] += prefix[i - 1][j];                // top area
                if(j > 0) prefix[i][j] += prefix[i][j - 1];               // left area
                if(i > 0 && j > 0) prefix[i][j] -= prefix[i - 1][j - 1];  // overlap removed

                
                if(prefix[i][j] <= k){
                    count++;
                }
            }
        }

        return count;
    }
}