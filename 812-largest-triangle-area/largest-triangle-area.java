class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double maxArea = 0.0;

        for(int i = 0 ; i < n ; i++){
            for(int j = i + 1 ; j < n ; j++){
                for(int k = j + 1 ; k < n ; k++){
                    
                    double x1 = points[i][0];
                    double y1 = points[i][1];

                    double x2 = points[j][0];
                    double y2 = points[j][1];

                    double x3 = points[k][0];
                    double y3 = points[k][1];

                    //Sides
                    double a = Math.hypot(x2 - x1 , y2 - y1);
                    double b = Math.hypot(x2 - x3, y2 - y3);
                    double c = Math.hypot(x3 - x1, y3 - y1);

                    //Semi Perimeter
                    double s = (a + b + c) * 0.5;

                    //Herone
                    double heron = Math.sqrt(Math.max(0.0, s * (s - a) * (s - b) * (s - c)));
                    maxArea = Math.max(maxArea , heron);
                }
            }
        }

        return maxArea;
    }
}