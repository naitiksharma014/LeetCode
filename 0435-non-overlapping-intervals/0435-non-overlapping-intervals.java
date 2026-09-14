// TC: O(n logn)

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int m = intervals.length;
        int n = intervals[0].length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // Sort on [i][0] 

        int i = 0, j = 1;
        int overLap = 0;

        while(j < m) {

            int currStart = intervals[i][0];
            int currEnd   = intervals[i][1];

            int nextStart = intervals[j][0];
            int nextEnd   = intervals[j][1];

            // CASE 1: No Overlap
            if(currEnd <= nextStart) {
                i = j;
                j++;
            }

            // CASE 2: OverLap

            else if(currEnd <= nextEnd) {
                overLap++;
                j++;
            }

            else if(currEnd > nextEnd) {
                overLap++;
                i = j;
                j++;
            }
        }

        return overLap;
    }
}