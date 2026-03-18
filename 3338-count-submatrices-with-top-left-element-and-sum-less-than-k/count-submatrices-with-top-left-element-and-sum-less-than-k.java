// ⏱️ Complexity
// Time: O(m × n)
// Space: O(1) 

class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int m = grid.length;     // row
        int n = grid[0].length;  // col

        int count = 0;

        for(int i = 0; i < m; i++){
            
            for(int j = 0; j < n; j++){

                if(i > 0) grid[i][j] += grid[i - 1][j];                // top area

                if(j > 0) grid[i][j] += grid[i][j - 1];               // left area

                if(i > 0 && j > 0) grid[i][j] -= grid[i - 1][j - 1];  // overlap removed

                
                if(grid[i][j] <= k){
                    count++;
                }
            }
        }

        return count;
    }
}