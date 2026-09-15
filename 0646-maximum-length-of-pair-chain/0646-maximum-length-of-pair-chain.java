// TC: O(m log m)

class Solution {
    public int findLongestChain(int[][] pairs) {
        int m = pairs.length;
        int n = pairs[0].length;

        Arrays.sort(pairs, (a, b)-> (a[1] - b[1]));

        int i = 0, j = 1;
        int chain = 1;

        while(j < m) {

            int currStart = pairs[i][0];
            int currEnd   = pairs[i][1];

            int nextStart = pairs[j][0];
            int nextEnd   = pairs[j][1];

            if(currEnd < nextStart) {
                i = j;
                j++;
                chain++;

            }
            else {
                j++;
            }
        }

        return chain;
    }
}