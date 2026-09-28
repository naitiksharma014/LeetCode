// Time Complexity  : O(V + E)
// Space Complexity : O(V + E)

class Edge {
    int source, destination;

    Edge(int source, int destination) {
        this.source = source;
        this.destination = destination;
    }
}

class Solution {

    public boolean DFS(ArrayList<Edge>[] graph, int curr, boolean[] vis, boolean[] st) {
        vis[curr] = true;
        st[curr] = true;

        for(Edge e: graph[curr]) {

            int nei = e.destination;

            if(st[nei]) {   // cycle found
                return true;
            }
            else if(!vis[nei]) {

                if(DFS(graph, nei, vis, st)) {
                    return true;
                }
            }
        }
        st[curr] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] prerequisite: prerequisites) {
            int a = prerequisite[0];
            int b = prerequisite[1];

            // b --> a (Complete b before a)
            graph[b].add(new Edge(b, a));
        }

        boolean[] vis = new boolean[V];
        boolean[] st = new boolean[V];
        
        for(int i = 0; i < V; i++) {

            if(!vis[i]) {

                if(DFS(graph, i, vis, st)) {
                    return false;
                }
            }
        }

        return true;
    }
}