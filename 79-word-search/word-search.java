class Solution {
    int n , m , l;
    int[][] directions = {{1 , 0} , {-1 , 0} , {0 , 1} , {0 , -1}};
    public boolean find(char[][] board , int i , int j , int idx , String word){
        if(idx >= l) return true;

        if(i >= n || j >= m || i < 0 || j < 0 || board[i][j] != word.charAt(idx)) return false;

        char temp = board[i][j];
        board[i][j] = '$';

        for(int[] dir : directions){
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            if( find(board , new_i , new_j , idx + 1 , word) ) return true;
        }

        board[i][j] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        n = board.length;       //Row
        m = board[0].length;    //Col
        l = word.length();  

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == word.charAt(0) && find(board , i , j , 0 , word)){
                    return true;
                }
            }
        }
        return false;
    }
}