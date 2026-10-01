// TC: O(n + m)
// SC: O(n + m)
// n = number of people
// m = dislikes.length

class Solution {
    class Edge {
        int source;
        int destination;

        Edge( int source, int destination) {
            this.source = source;
            this.destination = destination;
        }
    }

    public boolean BFS(ArrayList<Edge>[] graph, int n) {

        int[] color = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++) {

            if(color[i] != 0) {
                continue;
            }

            color[i] = 1;
            q.add(i);

            while(!q.isEmpty()) {

                int curr = q.poll();

                for(Edge e: graph[curr]) {

                    int neigh = e.destination;

                    if(color[neigh] == 0) {
                        color[neigh] = - color[curr];
                        q.add(neigh);
                    }
                    else if(color[neigh] == color[curr]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<Edge>[] graph = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] dislike: dislikes) {

            int a = dislike[0];
            int b = dislike[1];

            graph[b].add(new Edge(b, a));
            graph[a].add(new Edge(a, b));
        }

        return BFS(graph, n);
    }
}