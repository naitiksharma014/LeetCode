class Solution {
    int[][] t;
    public int solve(int i , int j , int m , int n , int[][] grid , int[][] t){
        //if(i < 0 || j < 0 || i > m || i > n) return 0;

        if(i == m - 1 && j == n - 1) return t[i][j] = grid[i][j];

        if(t[i][j] != -1) return t[i][j];
        
        if(i == m - 1){
            return t[i][j] = grid[i][j] + solve(i , j + 1 , m , n , grid , t);
        }
        else if(j == n - 1){
            return t[i][j] = grid[i][j] + solve(i + 1, j , m , n , grid , t);
        }
        else{
            return t[i][j] = grid[i][j] + Math.min(solve(i + 1, j , m , n , grid , t) , solve(i , j + 1, m , n , grid , t));
        }
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        t = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                t[i][j] = -1;
            }
        }

        

        return solve(0 , 0 , m , n , grid , t);
    }
}