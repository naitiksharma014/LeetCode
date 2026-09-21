// ⏱️ TC: O(V + E)

class Solution {
    public void DFS(List<List<Integer>> rooms, int curr,  boolean[] visited) {
        // if(visited[curr]) {
        //     return;
        // }

        visited[curr] = true;

        for(int neig: rooms.get(curr)) {
            if(!visited[neig]) {
                DFS(rooms, neig, visited);
            }
        }

    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];

        DFS(rooms, 0, visited);

        for(boolean visit: visited) {
            if(!visit) {
                return false;
            }
        }

        return true;
    }
}