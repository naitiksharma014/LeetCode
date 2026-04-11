// ⏱️ TC: O(n²)
// 📦 SC: O(n²)

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[n * n + 1];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }

        //int[] ans = new int[];
        int mis = -1, rep = -1;

        for(int i = 1; i <= n * n; i++) {
            if(freq[i] == 0) {
                mis = i;
            }
            if(freq[i] == 2) {
                rep = i;
            }
        }

        return new int[]{rep, mis};
    }
}