class Solution {
    int[][] t;
    public int solve(int i , int j , int m , int n , int[][] t){
        if(i == m - 1 && j == n - 1) return 1;

        if(i < 0 || j < 0 || i >= m || j >= n) return 0;

        if(t[i][j] != -1) return t[i][j];

        int right = solve(i , j + 1 , m , n , t);
        int down = solve(i + 1 , j , m , n , t);

        return t[i][j] = right + down;
    }
    public int uniquePaths(int m, int n) {
        t = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                t[i][j] = -1;
            }
        }

        int i = 0 , j = 0;
        return solve(i , j , m , n , t);
    }
}