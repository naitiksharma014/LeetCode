// ⏱️TC : O(V * E) = O(n²)
// 💾SC : O(V * E) = O(n²)

class Edge {
    int src, dest;

    Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }
}

class Solution {
    public void DFS(int src, ArrayList<Edge>[] graph, boolean[] vis) {
        if(vis[src]) {
            return;
        }

        vis[src] = true;

        for(Edge e: graph[src]) {
            
            int nei = e.dest;

            if(!vis[nei]) {
                DFS(nei, graph, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        // Built Graph
        ArrayList<Edge>[] graph = new ArrayList[n];

        // initialize each list
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {

                int u = i;
                int v = j;

                if(isConnected[i][j] == 1) {
                    graph[u].add(new Edge(u, v));
                    graph[v].add(new Edge(v, u));
                }
            }
        }

        boolean[] vis = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++) {

            if(!vis[i]) {
                DFS(i, graph, vis);
                count++;
            }
        }

        return count;
    }
}