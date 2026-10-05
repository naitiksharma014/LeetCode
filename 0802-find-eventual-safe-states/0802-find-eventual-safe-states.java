class Solution {

    public boolean DFS(int src, int[][] graph, boolean[] visited, boolean[] isRecursion) {
        visited[src] = true;
        isRecursion[src] = true;

        for(int neigh: graph[src]) {

            if(!visited[neigh]) {
                if(DFS(neigh, graph, visited, isRecursion)){
                    return true;
                }
            }
            else if(isRecursion[neigh]) {
                return true;
            }
        }

        isRecursion[src] = false;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        boolean[] isRecursion = new boolean[n];
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                DFS(i, graph, visited, isRecursion);
            }
        }

        List<Integer> list = new LinkedList<>();
        for(int i = 0; i < n; i++) {

            if(!isRecursion[i]) {
                list.add(i);
            }
        }

        return list;
    }
}