// TC: O(3^K)
// SC: O(K) (recursion stack).

class Solution {
    int m, n;
    int nonObstacle;

    public int solve(int i, int j, int[][] grid, int count) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == -1) {
            return 0;
        }

        if (grid[i][j] == 2) {
            return count == nonObstacle ? 1 : 0;
        }

        grid[i][j] = -1;

        int left  = solve(i, j - 1, grid, count + 1);
        int right = solve(i, j + 1, grid, count + 1);
        int down  = solve(i + 1, j, grid, count + 1);
        int up    = solve(i - 1, j, grid, count + 1);


        // Backtrack: restore original value
        grid[i][j] = 0;

        return left + right + down + up;
    }

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int start_i = 0, start_j = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 1) {
                    start_i = i;
                    start_j = j;
                }
                if(grid[i][j] == 0) {
                    nonObstacle++;
                }
            }
        }

        nonObstacle++;
        int count = 0;
        
        return solve(start_i, start_j, grid, count);        
    }
}