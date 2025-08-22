class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;    // Row
        int m = grid[0].length;  //column
        
        int minRow = n;
        int maxRow = -1;

        int minCol = m;
        int maxCol = -1;


        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){

                    minRow = Math.min(minRow , i);
                    maxRow = Math.max(maxRow , i);


                    minCol = Math.min(minCol , j);
                    maxCol = Math.max(maxCol , j);
                }
            }
        }


        return (maxRow - minRow + 1) * (maxCol - minCol + 1);
    }
}