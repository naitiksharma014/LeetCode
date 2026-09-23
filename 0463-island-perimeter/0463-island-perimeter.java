// TC: O(m * n)

class Solution {
    int n, m;
    int perimeter = 0;

    public void DFS(int i, int j, int[][] grid) {
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) {
            perimeter++;
            return;
        }

        if(grid[i][j] == -1) {
            return;
        }

        grid[i][j] = -1;

        DFS(i - 1, j, grid);
        DFS(i + 1, j, grid);
        DFS(i, j - 1, grid);
        DFS(i, j + 1, grid);
    }

    public int islandPerimeter(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {

                if(grid[i][j] == 1) {
                    DFS(i, j, grid);
                }
            }
        }

        return perimeter;
    }
}