class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = topRight.length;
        int maxSide = 0;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){

                // Width
                int topRightX = Math.min(topRight[i][0], topRight[j][0]);
                int bottomLeftX = Math.max(bottomLeft[i][0], bottomLeft[j][0]);

                int width = topRightX - bottomLeftX;

                // Height
                int topRightY =  Math.min(topRight[i][1], topRight[j][1]);
                int bottomLeftY = Math.max(bottomLeft[i][1], bottomLeft[j][1]);

                int height = topRightY - bottomLeftY;

                // Side will be minimum of Width and Height so it stays b/w overlapping
                int side = Math.min(height, width);

                maxSide = Math.max(maxSide, side);
            }
        }

        return 1L * maxSide * maxSide;
    }
}