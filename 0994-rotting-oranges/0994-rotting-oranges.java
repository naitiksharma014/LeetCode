// Multi-Source BFS
// ⏱️ TC: O(m × n) + O(4 × m × n) ≈ O(m × n)
// 📦 SC: Queue → O(m × n)


class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        int freshOrange = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});   // Rotten Orange
                }
                else if(grid[i][j] == 1) {
                    freshOrange++;
                }
            }
        }

        if(freshOrange == 0) {
            return 0;
        }

        int minutes = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while(!q.isEmpty()) {
            
            int N = q.size();

            while(N--> 0) {

                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];

                for(int[] direction: directions) {
                    int new_i = i + direction[0];
                    int new_j = j + direction[1];

                    if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && grid[new_i][new_j] == 1) {
                       grid[new_i][new_j] = 2;

                        freshOrange--;
                        q.add(new int[]{new_i, new_j});
                    }
                }
            }

            minutes++;
        }

        return freshOrange == 0 ? (minutes - 1) : -1;
    }
}