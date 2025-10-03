class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0 , j = n - 1;
        int area = 0;
        int maxArea = Integer.MIN_VALUE;

        while(i <= j){
            int l = Math.min(height[i] , height[j]);
            int w = j - i;
            area = l * w;
            maxArea = Math.max(maxArea , area);

            if(height[i] > height[j]) j--;
            else i++;
        }
        return maxArea;
    }
}