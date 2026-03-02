// TC: O(n²)
// SC: O(n)

class Solution {
    public void swap(int a, int b, int[] zeroArray){
        int temp = zeroArray[a];
        zeroArray[a] = zeroArray[b];
        zeroArray[b] = temp;
    }

    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int idx = 0;
        int zeroCount = 0;
        int[] zeroArray = new int[n];
        
        // count trailing zeros in each row
        for(int i = 0; i < n; i++){

            zeroCount = 0;

            for(int j = m - 1; j >= 0; j--){

                if(grid[i][j] == 1){
                    break;
                } else{
                    zeroCount++;
                }
            }

            zeroArray[i] = zeroCount;
        }
        
        int swaps = 0;
        
        // greedy placement
        for(int i = 0; i < n; i++){

            int need = n - i - 1;
            int j = i;
            
            // find suitable row
            while(j < n && need > zeroArray[j]){
                j++;
            }

            if(j == n) return -1;

            // bubble up
            while(j > i){
                swap(j, j - 1, zeroArray);
                swaps++;
                j--;
            }
        }

        return swaps;
    }
}