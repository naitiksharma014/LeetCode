// ⏱️TC : O(n²)
// 💾SC : O(n²)

class Solution {
    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public void DFS(int curr, ArrayList<Edge>[] graph, boolean[] visited) {
        visited[curr] = true;

        for(Edge e: graph[curr]) {
            int nei = e.dest;

            if(!visited[nei]) {
                DFS(nei, graph, visited);
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
                
                if(isConnected[i][j] == 1) {
                    graph[i].add(new Edge(i, j));
                    graph[j].add(new Edge(j, i));
                }
            }
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for(int i = 0; i < n; i++) {

            if(!visited[i]) {
                DFS(i, graph, visited);
                count++;
            }
        }

        return count;
    }
}