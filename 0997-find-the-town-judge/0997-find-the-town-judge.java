// ⏱️ Time Complexity: O(n + trust.length)
// 📦 Space Complexity: O(n)

class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];

        for(int[] t: trust) {

            int u = t[0];
            int v = t[1];

            outDegree[u]++;
            inDegree[v]++;
        }

        for(int i = 1; i <= n; i++) {

            if(inDegree[i] == n - 1 && outDegree[i] == 0) {
                return i;
            }
        }

        return -1;
    }
}