// TC = O(m*n)
// SC = O(1) 

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int top = 0, down = row - 1;
        int left = 0, right = col - 1;
        List<Integer> list = new ArrayList<>();

        while(top <= down && left <= right) {

            // left -> right
            for(int j = left; j <= right; j++) {
                list.add(matrix[top][j]);
            }
            top++;

            // top -> down
            for(int i = top; i <= down; i++) {
                list.add(matrix[i][right]);
            }
            right--;

            // right -> left
            if(top <= down) {
                for(int j = right; j >= left; j--) {
                    list.add(matrix[down][j]);
                }
                down--;
            }

            // down -> top
            if(left <= right) {
                for(int i = down; i >= top; i--) {
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }

        return list;
    }
}