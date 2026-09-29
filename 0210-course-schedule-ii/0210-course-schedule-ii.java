// Topological Sort-> Kahn's Algorithm

// Time Complexity: O(V + E)
// Space Complexity: O(V + E)

// where V = number of courses and
// E = number of prerequisite relations.

class Solution {
    int v;

    class Edge {
        int source;
        int destination;

        Edge(int source, int destination) {
            this.source =  source; 
            this.destination = destination;
        }
    }

    public int[] topologicalSort(ArrayList<Edge>[] graph, int[] indegree) {
        int[] res = new int[v];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < v; i++) {

            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int idx = 0;
        while(!q.isEmpty()) {

            int curr = q.poll();
            res[idx++] = curr;

            for(Edge e: graph[curr]) {

                int src = e.source;
                int dest = e.destination;

                indegree[dest]--;

                if(indegree[dest] == 0) {
                    q.add(dest);
                }
            }
        }

        return idx == v ? res : new int[]{}; 
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        v = numCourses;

        ArrayList<Edge>[] graph = new ArrayList[v];

        for(int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        int[] indegree = new int[v];

        for(int[] prerequisite: prerequisites) {

            int a = prerequisite[0];
            int b = prerequisite[1];

            graph[b].add(new Edge(b, a));
            indegree[a]++;
        }

        return topologicalSort(graph, indegree);
    }
}