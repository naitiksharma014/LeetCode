// DFS
// TC: O(V + E)
// SC: O(V + E)

class Edge {
    int source, destination;

    Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }
}

class Solution {
    public boolean DFS(ArrayList<Edge>[] graph, int sr, int ds, boolean[] vis) {
        if(sr == ds) {
            return true;
        }

        if(vis[sr] == true) {
            return false;
        }

        vis[sr] = true;

        for(Edge e: graph[sr]) {

            int s = e.source;
            int d = e.destination;

            if(!vis[d]) {
                if(DFS(graph, d, ds, vis)) {
                    return true;
                }
            }
        }

        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Build Graph
        ArrayList<Edge>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge: edges) {

            int u = edge[0];
            int v = edge[1];

            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }

        boolean[] vis = new boolean[n];

        return DFS(graph, source, destination, vis);
        
    }
}