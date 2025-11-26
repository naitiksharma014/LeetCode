class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        int count = 1;

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));

        int[] prev = points[0];

        for(int i = 1; i < n; i++){

            int prevStart = prev[0];
            int prevEnd   = prev[1];

            int currStart = points[i][0];
            int currEnd   = points[i][1];

            if(prevEnd < currStart){
                count++;
                prev = points[i];
            }
            else{
                prev[0] = Math.max(prevStart, currStart);
                prev[1]   = Math.min(prevEnd, currEnd);
            }
        }

        return count;
    }
}