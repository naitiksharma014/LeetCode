// BFS 
// Time Complexity: O(n²)
// Space Complexity: O(n²)

class Solution {
    int[][] directions = {
        {-1,-1},{-1,0},{-1,1},
        {0,-1},        {0,1},
        {1,-1},{1,0},{1,1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;


        Queue<int[]> q = new LinkedList<>();
        
        grid[0][0] = 1;
        q.add(new int[]{0, 0, 1});  // (i, j, dist)

        while(!q.isEmpty()) {

            int[] curr = q.poll();

            int i = curr[0];
            int j = curr[1];
            int dist = curr[2];

            if(i == n - 1 && j == n - 1) {
                return dist;
            }

            for(int[] direction: directions) {

                int new_i = i + direction[0];
                int new_j = j + direction[1];

                if(new_i >= 0 && new_i < n && new_j >= 0 && new_j < n && grid[new_i][new_j] == 0) {
                    grid[new_i][new_j] = 1;
                    q.add(new int[]{new_i, new_j, dist + 1});
                }
            }
        }

        return -1;
    }
}