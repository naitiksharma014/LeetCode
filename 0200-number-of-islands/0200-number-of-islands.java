// Time = O(m × n)
// Extra Space = O(m × n) only because of the recursion stack

class Solution {
    int m, n;

    public void DFS(int i, int j, char[][] grid, boolean[][] vis) {
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1' || vis[i][j]) {
            return;
        }

        vis[i][j] = true;

        DFS(i + 1, j, grid, vis);
        DFS(i - 1, j, grid, vis);
        DFS(i, j + 1, grid, vis);
        DFS(i, j - 1, grid, vis);
    } 

    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int island = 0;

        boolean[][] vis = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == '1' && !vis[i][j]) {
                    DFS(i, j, grid, vis);
                    island++;
                }
            }
        }

        return island;
    }
}