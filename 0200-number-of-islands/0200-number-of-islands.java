// TC: O(m * n)
// SC: O(m * n) — recursive stack

class Solution {
    int m, n;

    public void DFS(int i, int j, char[][] grid) {
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') {
            return;
        }

        grid[i][j] = 2;

        DFS(i + 1, j, grid);
        DFS(i - 1, j, grid);
        DFS(i, j + 1, grid);
        DFS(i, j - 1, grid);
    }

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == '1') {

                    DFS(i, j, grid);
                    count++;
                }
            }
        }

        return count;
    }
}