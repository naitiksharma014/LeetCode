class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int time = 0;

        for (int i = 0; i < n - 1; i++) {

            int x1 = points[i][0];
            int y1 = points[i][1];

            int x2 = points[i + 1][0];
            int y2 = points[i + 1][1];

            int dx = Math.abs(x1 - x2);
            int dy = Math.abs(y1 - y2);

            int diagonal = Math.min(dx, dy);
            int extraStep = Math.abs(dx - dy);

            time += diagonal + extraStep;
        }

        return time;
    }
}
