// TC: O(n²)

class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        
        /* Left      Right  
            0°   →   0°    →  (i, j)
            270° →   90°   →  (j, n - 1 - i)
            180° →   180°  →  (n - 1 - i, n - 1 - j)
            90°  →   270°  →  (n - 1 - j, i)
        */
        boolean r0 = true, r90 = true, r180 = true, r270 = true; 

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                if (target[i][j] != mat[i][j]) r0 = false;

                if (target[i][j] != mat[j][n - 1 - i]) r90 = false;

                if (target[i][j] != mat[n - 1 - i][n - 1 - j]) r180 = false;

                if(target[i][j] != mat[n - 1 - j][i]) r270 = false;
            }
        }

        return r0 || r90 || r180 || r270;
    }
}