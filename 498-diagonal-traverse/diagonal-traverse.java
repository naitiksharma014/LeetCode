class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;     //ROW
        int m = mat[0].length;  //COL

        Map<Integer , List<Integer>> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                
                int key = i + j;
                map.putIfAbsent(key , new ArrayList<>());
                map.get(key).add(mat[i][j]);
            }
        }

        boolean flip = true;

        for(int k = 0 ; k <= m + n -2 ; k++){
            List<Integer> list = new ArrayList<>(map.get(k));

            if(list == null) continue;

            if(flip){
                Collections.reverse(list);
            }

            res.addAll(list);
            flip = !flip;
        }

        int arr[] = new int[res.size()];

        for(int i = 0 ; i <  res.size() ; i++){
            arr[i] = res.get(i);
        }

        return arr;
    }
}