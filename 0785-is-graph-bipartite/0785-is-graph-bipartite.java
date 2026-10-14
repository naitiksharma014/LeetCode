// Time Complexity: O(V + E)   V = number of vertices and E = number of edges.
// Space Complexity: O(V)

class Solution {
    public boolean DFS(int src, int[][] graph, int[] color) {
       
        for(int neigh: graph[src]) {

            if(color[neigh] == 0) {

                color[neigh] = - color[src];

                if(!DFS(neigh, graph, color)) {
                    return false;
                }
            }
            else if(color[neigh] == color[src]) {
                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int[] color = new int[n];

        for(int i = 0; i < n; i++) {

            if(color[i] == 0) {

                color[i] = 1;

                if(!DFS(i, graph, color)) {
                    return false;
                }
            }
    
        }

        return true;
    }
}