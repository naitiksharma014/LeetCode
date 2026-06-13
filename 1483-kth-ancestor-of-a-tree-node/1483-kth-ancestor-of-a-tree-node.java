//Approach (Using Binary Lifting)
//T.C : O(Q * log(n)) , Q = number of queries , n = number of nodes
//S.C : O(n * log(n)) to store events in map

class TreeAncestor {

    int row, col;
    int[][] ancestorTable;

    public TreeAncestor(int n, int[] parent) {
        row = n;
        col = (int) ( Math.log(n) / Math.log(2) ) + 1;

        ancestorTable = new int[row][col];

        // Initialize ByDefault with -1
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                ancestorTable[i][j] = -1;
            }
        }

        // Fill 1st Col of each row
        for(int i = 0; i < row; i++) {
            ancestorTable[i][0] = parent[i];
        }

        for(int j = 1; j < col; j++) {
            for(int node = 0; node < row; node++) {
                
                if(ancestorTable[node][j - 1] != -1) {
                    ancestorTable[node][j] = ancestorTable[ ancestorTable[node][j - 1] ][j - 1];
                }
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for(int j = 0; j < col; j++) {           //O(log(n))

            if( (k & (1 << j)) != 0) {           //is used to check whether the j-th bit of k is set (1) or not.
                node = ancestorTable[node][j];
            }

            if(node == -1) {
                return -1;
            }
        }

        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */