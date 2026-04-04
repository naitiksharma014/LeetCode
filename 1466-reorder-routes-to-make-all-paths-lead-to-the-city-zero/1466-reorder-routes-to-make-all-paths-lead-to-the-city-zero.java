// ⏱️ TC: O(V + E)
// 💾 SC: O(V + E)

class Solution {
    
    static class Edge {
        int src, dest;
        int cost; 
        
        Edge(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }

    int count = 0;

    public void DFS(int curr, ArrayList<Edge> graph[], boolean[] visited){
        visited[curr] = true;

        for(Edge e: graph[curr]) {
            int nei = e.dest;
            int cost = e.cost;

            if(!visited[nei]) {
                
                if(cost == 1) {
                    count++;
                }
                DFS(nei, graph, visited);
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        ArrayList<Edge> graph[] = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] connection: connections) {

            int u = connection[0];
            int v = connection[1];

            // REAL: u -> v (1)
            // FAKE: v -> u (0)

            // original edge → needs reversal
            graph[u].add(new Edge(u, v, 1));

            // reverse edge → already correct
            graph[v].add(new Edge(v, u, 0));
        }

        boolean[] visited = new boolean[n];
        DFS(0, graph, visited);
        
        return count;
    }
}