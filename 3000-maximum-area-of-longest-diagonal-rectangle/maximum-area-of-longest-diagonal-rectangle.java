class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;

        int maxA = 0;
        int maxD = 0;

        for(int i = 0 ; i < n ; i++){

            int l = dimensions[i][0];
            int w = dimensions[i][1];

            int A = l * w;
            int D = l * l + w * w;

            if(D > maxD){
                maxD = D;
                maxA = A;
            }
            else if(D == maxD){
                maxA = Math.max(maxA , A);
            }
        }

        return maxA;
    }
}