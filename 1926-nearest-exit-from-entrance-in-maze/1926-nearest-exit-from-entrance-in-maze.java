// BFS
// ⏱️ TC: O(m × n)
// 📦 SC: O(m × n)

class Solution {
    int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0], entrance[1]});

        //  mark visited
        maze[entrance[0]][entrance[1]] = '+';

        int steps = 0;

        // BFS
        while(!q.isEmpty()) {

            int N = q.size();

            while(N--> 0) {
                int[] curr = q.poll();
                int i = curr[0], j = curr[1];

                // check exit (not entrance + boundary)
                if(!(i == entrance[0] && j == entrance[1]) && 
                    (i == 0 || i == m - 1 || j == 0 || j == n - 1)) {
                    return steps;
                }

                for(int[] dir: directions) {
                    int new_i = i + dir[0];
                    int new_j = j + dir[1];

                    if(new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && maze[new_i][new_j] != '+') {
                        q.add(new int[]{new_i, new_j});
                        maze[new_i][new_j] = '+';
                    }
                }
            }

            steps++;
        }

        return -1;
    }
}