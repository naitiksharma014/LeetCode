// TC: O(n)
// SC: O(n)

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        while(!st.isEmpty()) {
            st.pop();
        }
        
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }

            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        int maxArea = 0;

        for(int i = 0; i < n; i++) {

            int height = heights[i];
            int width = right[i] - left[i] - 1;
            int currArea = height * width;

            maxArea = Math.max(maxArea, currArea); 
        }

        return maxArea;
    }
}