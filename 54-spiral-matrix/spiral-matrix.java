class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length; //row
        int n = matrix[0].length; //col

        int top = 0 , left = 0;
        int down = m - 1 , right = n - 1;

        int dirn = 0;

        List<Integer> res = new ArrayList<>();

        while( top <= down && left <= right ){

            if( dirn == 0 ){
                for( int i = left ; i <= right ; i++ ){
                    res.add( matrix[top][i] );
                }
                top++;
            }

            if( dirn == 1 ){
                for( int i = top ; i <= down ; i++ ){
                    res.add( matrix[i][right] );
                }
                right--;
            }

            if( dirn == 2 ){
                for( int i = right ; i >= left ; i-- ){
                    res.add( matrix[down][i] );
                }
                down--;
            }

            if( dirn == 3 ){
                for( int i = down ; i >= top ; i-- ){
                    res.add( matrix[i][left] );
                }
                left++;
            }

            dirn = ( dirn + 1 ) % 4;
        }

        return res;
    }
}