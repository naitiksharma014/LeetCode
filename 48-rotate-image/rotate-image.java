class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;     //Row
        int m = matrix[0].length;  //Col

        //Reversal
        int top = 0;
        int bottom = n - 1;

        while(top < bottom){
            
            for(int i = 0 ; i < n ; i++){
                int temp = matrix[top][i];
                matrix[top][i] = matrix[bottom][i];
                matrix[bottom][i] = temp;
            }

            top++;
            bottom--;
        }


        //Transpose
        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}