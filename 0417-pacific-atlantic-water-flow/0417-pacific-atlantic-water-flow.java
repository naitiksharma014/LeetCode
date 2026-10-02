// TC: O(m × n)
// SC: O(m × n)

class Solution {
    int m, n;

    private void DFS(int[][] heights, int r, int c, int prevHeight, boolean[][] vis) {

    if(r < 0 || r >= m || c < 0 || c >= n || vis[r][c] || heights[r][c] < prevHeight)
        return;

    vis[r][c] = true;

    DFS(heights, r + 1, c, heights[r][c], vis);
    DFS(heights, r - 1, c, heights[r][c], vis);
    DFS(heights, r, c + 1, heights[r][c], vis);
    DFS(heights, r, c - 1, heights[r][c], vis);
}

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();

        for(int col = 0; col < n; col++) {

            //  Pacific
            int firstRow = 0;

            if(!pacific[firstRow][col]) {
                DFS(heights, firstRow, col, -1, pacific);
            }


            //  Atlantic
            int lastRow = m - 1;

            if(!atlantic[firstRow][col]) {
                DFS(heights, lastRow, col, -1, atlantic);
            }

        }

        for(int row = 0; row < m; row++) {

            //  Pacific
            int firstCol = 0;

            if(!pacific[row][firstCol]) {
                DFS(heights, row, firstCol, -1, pacific);
            }

            


            //  Atlantic
            int lastCol = n - 1;

            if(!atlantic[row][lastCol]) {
                DFS(heights, row, lastCol, -1, atlantic);
            }
        }
        

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(pacific[i][j] && atlantic[i][j]) {
                    list.add(Arrays.asList(i, j));
                }
            }
        }

        return list;
    }
}