// K = Maximum number of stops allowed
// TC: O(K * N²)
// SC: O(N²)

class Solution {
    class Edge {
        int source;
        int destination;
        int weight;

        Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<Edge> graph[] = new ArrayList[n];
        for(int i = 0; i < n; i++) {

            graph[i] = new ArrayList<>();
        }

        for(int[] flight: flights) {

            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];

            graph[u].add(new Edge(u, v, cost));
        }

        Queue<int[]> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        q.add(new int[]{src, 0, -1});     // src, cost, stop

        while(!q.isEmpty()) {

            int[] curr = q.poll();

            int u = curr[0];
            int cost = curr[1];
            int stop = curr[2];

            for(Edge e: graph[u]) {

                int v = e.destination;
                int wt = e.weight;

                if(dist[v] > cost + wt && stop + 1 <= k) {

                    dist[v] = cost + wt;
                    q.add(new int[]{v, dist[v], stop + 1});
                }
            } 
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}