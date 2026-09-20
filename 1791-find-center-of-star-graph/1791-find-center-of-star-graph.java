class Solution {
    public int findCenter(int[][] edges) {
        int V = 0;

        for(int[] edge: edges) {

            int u = edge[0];
            int v = edge[1];

            V = Math.max(V, Math.max(u, v));
        }


        int[] Edges = new int[V + 1];

        for(int[] edge: edges) {

            int u = edge[0];
            int v = edge[1];

            Edges[u]++;
            Edges[v]++;
        }

        for(int i = 1; i <= V; i++) {

            if(Edges[i] == V - 1) {
                return i;
            }
        }

        return -1;
    }
}