// DFS
// TC: O(V + E)
// SC: O(V + E)

class Solution {
    static class Edge {
        int src, dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public boolean DFS(int s, int d, ArrayList<Edge> graph[], boolean[] vis) {
        if(s == d) {
            return true;
        }

        if(vis[s] == true) {
            return false;
        }

        vis[s] = true;

        for(Edge e: graph[s]) {
            int nei = e.dest;

            if(!vis[nei]){
                if(DFS(nei, d, graph, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<Edge> graph[] = new ArrayList[n];

        // Build graph
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: edges) {

            int u = edge[0];
            int v = edge[1];

            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }

        boolean[] vis = new boolean[n];
        return DFS(source, destination, graph, vis);
    }
}