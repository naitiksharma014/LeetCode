//---------------------------------------------------(Approach - 1)-------------------------------------------------------------
// Better
// TC: O(m × n)
// Sc: O(m + n)

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                
                if(matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                
                if(row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}


//---------------------------------------------------(Approach - 2)-------------------------------------------------------------
// Optimal Approach
// TC:  O(m × n)
// SC: O(1)

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean firstRow = false, firstCol = false;


        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(matrix[i][0] == 0) {
                    firstRow = true;
                }

                if(matrix[0][j] == 0) {
                    firstCol = true;
                }
            }
        }
        
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {

                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }


        if(firstRow) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        if(firstCol) {
            for(int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}
