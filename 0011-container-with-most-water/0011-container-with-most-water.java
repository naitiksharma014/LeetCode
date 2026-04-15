// Two Pointer Approach (Greedy)
// ⏱️ TC: O(n)
// 💾 SC: O(1)

class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int i = 0;
        int j = n - 1;

        while(i < j) {

            int l = Math.min(height[i], height[j]);
            int w = j - i;
            int area = l * w;

            maxArea = Math.max(maxArea, area);

            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }
}