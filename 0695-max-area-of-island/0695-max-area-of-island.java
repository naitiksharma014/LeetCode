// TC: O(m × n)
// SC: O(m × n)

class Solution {
    int m, n;
    int area = 0;
    int maxArea = 0;

    public void DFS(int[][] grid, int i, int j) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != 1) {
            return;
        }

        grid[i][j] = 2;
        area++;

        DFS(grid, i + 1, j);
        DFS(grid, i - 1, j);
        DFS(grid, i, j + 1);
        DFS(grid, i, j - 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 1) {

                    area = 0;
                    DFS(grid, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }

        return maxArea;
    }
}