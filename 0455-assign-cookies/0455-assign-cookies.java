// TC: Sorting: O(n log n + m log m) + Two pointers: O(n + m)

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int m = g.length;
        int n = s.length;

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;

        while(i < m && j < n) {

            if(g[i] <= s[j]) {
                i++;
            }

            j++;
        }

        return i;
    }
}