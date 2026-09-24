// TC: O(m * n)
// SC: O(m * n)

class Solution {
    int m, n;

    public void DFS(int i, int j, int[][] graph) {
        if(i < 0 || i >= m || j < 0 || j >= n || graph[i][j] == 0) {
            return;
        }

        graph[i][j] = 0;

        DFS(i + 1, j, graph);
        DFS(i - 1, j, graph);
        DFS(i, j + 1, graph);
        DFS(i, j - 1, graph);
    }

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        
        for (int col = 0; col < n; col++) {

            // Top row
            if(grid[0][col] == 1) {
                DFS(0, col, grid);
            }

            // Bottom row
            if(grid[m - 1][col] == 1) {
                DFS(m - 1, col, grid);
            }     
        }

       
        for (int row = 1; row < m; row++) {

            // Left column
            if(grid[row][0] == 1) {
                DFS(row, 0, grid);
            }
            
            // Right column
            if(grid[row][n - 1] == 1) {
                DFS(row, n - 1, grid);
            }
        }     

        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}