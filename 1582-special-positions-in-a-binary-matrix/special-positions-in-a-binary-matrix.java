//-------------------------------------------------------------------------------(Approach - 1)----------------------------------------------------------------------------------------------------
// TC: O(m * n * (m + n))
// SC: O(1)
// Brute Force

class Solution {
    public boolean checkRow(int[][] arr, int i, int j, int n){
        for(int col = 0; col < n; col++){
            if(col != j && arr[i][col] == 1){
                return false;
            }
        }
        return true;
    }

    public boolean checkCol(int[][] arr, int i, int j, int m){
        for(int row = 0; row < m; row++){
            if(row != i && arr[row][j] == 1){
                return false;
            }
        }
        return true;
    }

    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if(mat[i][j] == 1 && checkRow(mat, i, j, n) && checkCol(mat, i, j, m)){
                    count++;
                }
            }
        }

        return count;
    }
}



//-------------------------------------------------------------------------------(Approach - 2)----------------------------------------------------------------------------------------------------
// TC: O(m * n)
// SC: O(m + n)
// Optimal

class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] row = new int[m];
        int[] col = new int[n];

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if(mat[i][j] == 1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int count = 0;

        for(int i = 0; i < m; i++){

            for(int j = 0; j < n; j++){

                if(mat[i][j] == 1 && row[i] == 1 && col[j] == 1){
                    count++;
                }
            }
        }

        return count;
    }
}
