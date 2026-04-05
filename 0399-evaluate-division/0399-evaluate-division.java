class Solution {

    static class Edge {
        String src, dest;
        double weight;

        Edge(String s, String d, double w) {
            this.src = s;
            this.dest = d;
            this.weight = w;
        }
    }

    public void DFS(Map<String, List<Edge>> adj, String src, String dest, Set<String> visited, double product, double[] ans) {
        if(visited.contains(src)) {
            return;
        }

        visited.add(src);

        if(src.equals(dest)) {
            ans[0] = product;
            return;
        }

        for(Edge e: adj.getOrDefault(src, new ArrayList<>())) {
            if(ans[0] != -1.0) return;

            String nei = e.dest;
            double wei = e.weight;

            DFS(adj, nei, dest, visited,  product * wei, ans);
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
       
        // Step 1: Build graph
        Map<String, List<Edge>> adj = new HashMap<>();

        for(int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            if(!adj.containsKey(u)) {
                adj.put(u, new ArrayList<>());
            }
            adj.get(u).add(new Edge(u, v, val));

            if(!adj.containsKey(v)) {
                adj.put(v, new ArrayList<>());
            }
            adj.get(v).add(new Edge(v, u, 1.0 / val));
        }

        // Step 2: Process queries
        double[] result = new double[queries.size()];

        for(int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            double[] ans = new double[]{-1.0};

            if(adj.containsKey(src)) {
                Set<String> visited = new HashSet<>();
                DFS(adj, src, dest, visited, 1.0, ans);
            }

            result[i] = ans[0];
        }

        return result;
    }
}