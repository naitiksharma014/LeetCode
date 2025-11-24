class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int m = intervals.length;
        int n = intervals[0].length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int i = 0, j = 1;
        int count = 0;

        while(j < m){

            int currStart = intervals[i][0];
            int currEnd   = intervals[i][1];

            int nextStart = intervals[j][0];
            int nextEnd   = intervals[j][1];

            //No Overlapping
            if(currEnd <= nextStart){
                i = j;
                j++;
            }

            //Overlapping
            else if(currEnd <= nextEnd){
                count++;
                j++;
            }

            else if(currEnd > nextEnd){
                count++;
                i = j;
                j++;
            }

        }

        return count;
    }
}