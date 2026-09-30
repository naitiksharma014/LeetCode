// BFS
// TC: O(V + E)
// SC: O(V + E)

class Solution {
    int v;
    int[] color;

    public boolean BFS(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < v; i++) {

            if(color[i] != 0) {
                continue;
            }

            q.add(i);
            color[i] = 1;

            while(!q.isEmpty()) {

                int curr = q.poll();

                for(int neigh: graph[curr]) {

                    if(color[neigh] == 0) {
                        color[neigh] = -color[curr];
                        q.add(neigh);
                    }
                    else if(color[neigh] == color[curr]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        v = graph.length;

        color = new int[v];    // 0 = uncolored, 1 = red, -1 = blue

        return BFS(graph);
    }
}