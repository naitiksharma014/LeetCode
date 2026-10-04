// Time: O(P × L)       P = number of paths, L = average path length
// Space: O(P × L) for the output
// Auxiliary Space: O(L) (recursion stack + current path)

class Solution {

    int n;
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public void DFS(int[][] graph, int node) {
        path.add(node);

        if(node == n - 1) {
            result.add(new ArrayList<>(path));
        }
        else {

            for(int nei: graph[node]) {
                DFS(graph, nei);
            }
        }

        path.remove(path.size() - 1);   // BackTracking
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;

        DFS(graph, 0);

        return result;
    }
}