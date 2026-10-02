// DFS
// TC: O(V²)
// SC: O(V²)

class Solution {
    class Edge {
        int source;
        int destination;

        Edge(int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public boolean DFS(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {
        if(src == dest) {
            return  true;
        }

        vis[src] = true;

        for(Edge e: graph[src]) {

            int neigh = e.destination;

            if(!vis[neigh]) {
                if(DFS(graph, neigh, dest, vis)) {
                    return true;
                }
            }
        }

        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int V = edges.length;

        ArrayList<Edge>[] graph = new ArrayList[V + 1];

        for(int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: edges) {

            int u = edge[0];
            int v = edge[1];

            boolean[] vis = new boolean[V + 1];

            if(!graph[u].isEmpty() && !graph[v].isEmpty() && DFS(graph, u, v, vis)) {
                return edge;    // new int[]{u, v}
            }

            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }

        return new int[]{-1, -1};
    }
}