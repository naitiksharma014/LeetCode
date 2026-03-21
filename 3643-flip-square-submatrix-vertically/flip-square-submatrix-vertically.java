class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int startRow = x;
        int endRow = x + k - 1;

        int startCol = y;
        int endCol = y + k - 1;

        for(int i = startRow; i <= endRow; i++){
            for(int j = startCol; j <= endCol; j++){
                
                // swap(grid[i][j], grid[endRow][j]);
                int temp = grid[i][j];
                grid[i][j] = grid[endRow][j];
                grid[endRow][j] = temp;
            }
            endRow--;
        }

        return grid;
    }
}