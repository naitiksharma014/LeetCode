// Time Complexity: O(8 ^ n²⁾) 

class Solution {
    int n;

    public boolean solve(int[][] grid, int row, int col, int expVal) {
        if(row < 0 || col < 0 || row >= n || col >= n || grid[row][col] != expVal) {
            return false;
        }

        if(expVal == n * n - 1) {
            return true;
        }


        // All Possible moves of knight(horse)
        boolean ans1 = solve(grid, row - 2, col + 1, expVal + 1);
        boolean ans2 = solve(grid, row - 1, col + 2, expVal + 1);
        boolean ans3 = solve(grid, row + 1, col + 2, expVal + 1);
        boolean ans4 = solve(grid, row + 2, col + 1, expVal + 1);
        boolean ans5 = solve(grid, row + 2, col - 1, expVal + 1);
        boolean ans6 = solve(grid, row + 1, col - 2, expVal + 1);
        boolean ans7 = solve(grid, row - 1, col - 2, expVal + 1);
        boolean ans8 = solve(grid, row - 2, col - 1, expVal + 1);

        return ans1 || ans2 || ans3 || ans4 || ans5 || ans6 || ans7 || ans8;

    }
    public boolean checkValidGrid(int[][] grid) {
        n = grid.length;

        return solve(grid, 0, 0, 0);
    }
}