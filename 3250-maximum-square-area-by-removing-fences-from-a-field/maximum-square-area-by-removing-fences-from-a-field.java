class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        int M = 1000000007;

        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];

        h[0] = 1;
        h[1] = m;

        for(int i = 0; i < hFences.length; i++){
            h[i + 2] = hFences[i];
        }

        v[0] = 1;
        v[1] = n;

        for(int i = 0; i < vFences.length; i++){
            v[i + 2] = vFences[i];
        }

        Arrays.sort(h);
        Arrays.sort(v);

        HashSet<Integer> heightSet = new HashSet<>();

        // store all possible heights
        for(int i = 0; i < h.length; i++){
            for(int j = i + 1; j < h.length; j++){
                heightSet.add(h[j] - h[i]);
            }
        }
        
        int maxSide = 0;

        // check vertical widths which match any height
        for(int i = 0; i < v.length; i++){
            for(int j = i + 1; j < v.length; j++){
                int width = v[j] - v[i];

                if(heightSet.contains(width)){
                    maxSide = Math.max(maxSide, width);
                }
            }
        }
        
        return maxSide == 0 ? -1 : (int)((1L * maxSide * maxSide) % M);
    }
}