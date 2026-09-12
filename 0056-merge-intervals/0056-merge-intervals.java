// Sorting: O(n log n)
// Merging: O(n)
// Total: O(n log n) 

class Solution {
    public int[][] merge(int[][] intervals) {
        int m = intervals.length;
        int n = intervals[0].length;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> ans = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i = 1; i < m; i++) {

            if(intervals[i][0] <= end) {
                end = Math.max(end, intervals[i][1]);
            }
            else {
                ans.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        ans.add(new int[]{start, end});

        return ans.toArray(new int[ans.size()][]);
    }
}