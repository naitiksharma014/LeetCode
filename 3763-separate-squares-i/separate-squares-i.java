class Solution {
    public boolean isBottom_Area_Greater_Than_Half(int[][] squares, double midY, double totalArea){
        //To Find Area of Bottom
        double bottomArea = 0.0;

        for(int[] square: squares){

          double x = square[0];
          double y = square[1];
          double l = square[2];

          double bottomY = y;
          double topY = y + l;

          if(midY >= topY){
            // full square below
            bottomArea += l * l;
          }
          else if(midY > bottomY){
            // partial square below
            bottomArea += l * (midY - y);
          }
        }

        return bottomArea >= (totalArea) / 2.0;  //Is bottom area more than above ?
    }
    public double separateSquares(int[][] squares) {
       double low = Double.MAX_VALUE;
       double high = Double.MIN_VALUE;
       double totalArea = 0.0;

       for(int[] square: squares){
          
          double x = square[0];
          double y = square[1];
          double l = square[2];

          totalArea += (l * l);

          low = Math.min(low, y);
          high = Math.max(high, y + l);
        }

        double resultY = 0.0;

        while(high - low > 1e-5){

            double midY = low + (high - low) / 2;
            resultY = midY;

            if(isBottom_Area_Greater_Than_Half(squares, midY, totalArea)){
                high = midY;
            }
            else{
                low = midY;
            }
        }

        return resultY;
    }
}