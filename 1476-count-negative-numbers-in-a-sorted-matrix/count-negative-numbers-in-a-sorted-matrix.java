//---------------------------------------------------------------(APPROACH - 1)--------------------------------------------------------------------------------
//Brute Force
//TC: O(m * n)

class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] < 0){
                    count++;
                }
            }
        }

        return count;
    }
}





//---------------------------------------------------------------(APPROACH - 2)--------------------------------------------------------------------------------
//Better (using binary search)
//TC: O(m log n)


class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result = 0;

        for (int i = 0; i < m; i++) {
            int idx = firstNegativeIndex(grid[i]);
            result += (n - idx);
        }
        return result;
    }

    // Finds first index where value < 0
    private int firstNegativeIndex(int[] row) {
        int left = 0, right = row.length - 1;
        int ans = row.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (row[mid] < 0) {
                ans = mid;
                right = mid - 1;   // move left to find earlier negative
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}





//---------------------------------------------------------------(APPROACH - 3)--------------------------------------------------------------------------------
//Optimal
//TC: O(m + n)

class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int row = 0, col = n - 1;
        int count = 0;

        while(row < m && col >= 0){

            if(grid[row][col] < 0){
                count += (m - row);
                col--;
            }
            else{
                row++;
            }
        }

        return count;
    }
}
