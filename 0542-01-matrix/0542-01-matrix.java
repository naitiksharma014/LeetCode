// Approach: (Using BFS) 
// Time : O(m*n)

class Pair {
    int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {

    int[][] directions = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };

    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] res = new int[m][n];
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(mat[i][j] == 0) {
                    q.add(new Pair(i, j));
                }
                else {
                    res[i][j] = -1;
                }
            }
        }

        while(!q.isEmpty()) {

            Pair curr = q.poll();

            int i = curr.first;
            int j = curr.second;

            for(int[] direction: directions) {

                int new_i = i + direction[0];
                int new_j = j + direction[1];

                if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && res[new_i][new_j] == -1) {

                    res[new_i][new_j] = 1 + res[i][j];
                    q.add(new Pair(new_i, new_j));
                }
            }
        }

        return res;
    }
}