// ⏱️ TC: O(V + E)

class Solution {
    public void DFS(List<List<Integer>> rooms, int curr, boolean[] visited) {
        visited[curr] = true;

        for(int nei: rooms.get(curr)) {
            if(!visited[nei]) {
                DFS(rooms, nei, visited);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited= new boolean[n];

        DFS(rooms, 0, visited);

        for(boolean visit: visited) {
            if(!visit) {
                return false;
            }
        }

        return true;
    }
}