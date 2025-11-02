class Solution {
    public void markGuard(int row , int col , int[][] grid , int m , int n){
        //Left to right
        for(int i = col + 1; i < n; i++){
              if(grid[row][i] == 2 || grid[row][i] == 3){
                break;
            }
            grid[row][i] = 1; //marked
        }
       
        //Right to left      
        for(int i = col - 1; i >= 0; i--){
            if(grid[row][i] == 2 || grid[row][i] == 3){
                break;
            }
            grid[row][i] = 1; //marked
        }

         //Down to Up     
        for(int i = row - 1; i >= 0; i--){
            if(grid[i][col] == 2 || grid[i][col] == 3){
                break;
            }
            grid[i][col] = 1; //marked
        }

        //Up to Down
        for(int i = row + 1; i < m; i++){
              if(grid[i][col] == 2 || grid[i][col] == 3){
                break;
            }
            grid[i][col] = 1; //marked
        }
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for(int val[] : guards){
            grid[val[0]][val[1]] = 2; //Pos of Guards
        }

        for(int wall[] : walls){
            grid[wall[0]][wall[1]] = 3;  //Pos of Walls
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               
                if(grid[i][j] == 2){

                    markGuard(i , j , grid , m , n);

                }
            }
        }

        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               
                if(grid[i][j] == 0){

                    count++;

                }
            }
        }
        return count;    
    }
}