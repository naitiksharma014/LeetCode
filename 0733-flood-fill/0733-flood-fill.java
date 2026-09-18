// TC = O(m × n)
// SC = O(m × n) -> Recursion Stack

class Solution {
    int m, n;

    public void DFS(int[][] image, int i, int j, int newColor, int oldColor) {
        if(i < 0 || j < 0 || i >= m || j >= n || image[i][j] == newColor || image[i][j] != oldColor) {
            return;
        }

        image[i][j] = newColor;

        DFS(image, i + 1, j, newColor, oldColor);
        DFS(image, i - 1, j, newColor, oldColor);
        DFS(image, i, j + 1, newColor, oldColor);
        DFS(image, i, j - 1, newColor, oldColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;

        if (image[sr][sc] == color) return image;

        DFS(image, sr, sc, color, image[sr][sc]);

        return image;
    }
}