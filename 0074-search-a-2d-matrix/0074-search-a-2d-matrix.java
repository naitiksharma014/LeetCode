// 🧠 Binary Search in 2D
// ⏱️ Time: O(log(m * n))
// 📦 Space: O(1)

class Solution {

    public boolean searchInRow(int[][] matrix, int row, int target, int n) {
        int left = 0, right = n - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;

            if(matrix[row][mid] == target) {

                return true;

            } else if(matrix[row][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int startRow = 0, endRow = m - 1;

        while(startRow <= endRow) {

            int midRow = startRow + (endRow - startRow) / 2;

            if(matrix[midRow][0] <= target && matrix[midRow][n - 1] >= target) {
                // search in the row
                return searchInRow(matrix, midRow, target, n);

            } else if(target > matrix[midRow][n - 1]) {
                startRow = midRow + 1;
            } 
            else {
                endRow = midRow - 1;
            }
        }

        return false;
    }
}