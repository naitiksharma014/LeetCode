class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int rows = mat.length;
        int cols = mat[0].length;

        int[][] prefix = new int[rows][cols];

        // Build Prefix Array
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                prefix[i][j] =   mat[i][j] + 
                                (i > 0 ? prefix[i - 1][j] : 0) + 
                                (j > 0 ? prefix[i][j - 1] : 0) - 
                                ( (i > 0 && j > 0) ? prefix[i - 1][j - 1] : 0);
            }
        }

        int best = 0;

        // Actual Logic : To form a square need two points diagonally opposit --> { a(i, j), b(i + offset, j + offset) }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                for(int offset = 0; offset < Math.min(rows - i, cols - j); offset++){

                    int x1 = i, y1 = j;
                    int x2 = i + offset, y2 = j + offset;

                    int sum = prefix[x2][y2];
                    
                    if(i > 0) sum -= prefix[i - 1][y2];
                    if(j > 0) sum -= prefix[x2][j - 1];
                    if(i > 0 && j > 0) sum += prefix[i - 1][j - 1];

                    if(sum <= threshold){
                        best = Math.max(best, offset + 1);
                    }
                    else{
                        break;
                    }
                }
            }
        }

        return best;
    }
}