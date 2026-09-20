// TC: O(1)

class Solution {
    public int findCenter(int[][] edges) {

        // 1st element satisfies all condition
        if(edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        }

        // otherwise 2nd element
        return edges[0][1];
    }
}