//Approach-2 (Using DFS)
//T.C : O(V*(V+E))
//S.C : O(V+E)
class Solution {

    private int dfs(int curr, Map<Integer, List<Integer>> adj, int d, int parent) {
        if (d < 0) return 0;

        int count = 1; // count current node

        for (int neighbor : adj.getOrDefault(curr, new ArrayList<>())) {
            if (neighbor != parent) {
                count += dfs(neighbor, adj, d - 1, curr);
            }
        }

        return count;
    }

    private int[] findCount(int[][] edges, int d) {
        int N = edges.length + 1;
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = dfs(i, adj, d, -1);
        }

        return result;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int N = edges1.length + 1;

        int[] result1 = findCount(edges1, k);
        int[] result2 = findCount(edges2, k - 1);

        int maxTargetNodesCount = Arrays.stream(result2).max().getAsInt();

        for (int i = 0; i < N; i++) {
            result1[i] += maxTargetNodesCount;
        }

        return result1;
    }
}