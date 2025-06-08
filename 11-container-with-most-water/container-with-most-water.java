class Solution {
    public int maxArea(int[] height) {
        int n = height.length;

        //TWO POINTER
        int lp = 0;
        int rp = n-1;

        int maxWater = 0;

        while(lp<=rp){
            int ht = Math.min(height[lp],height[rp]);
            int wt = rp - lp;

            int currWater = ht * wt;

            maxWater = Math.max(maxWater,currWater);

            if(height[lp]<height[rp]) lp++;
            else rp--;
        }

        return maxWater;
    }
}