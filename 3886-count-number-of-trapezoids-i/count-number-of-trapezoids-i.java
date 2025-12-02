class Solution {
    long M = 1000000007;
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int point[]: points){
            int y = point[1];

            map.put(y, map.getOrDefault(y, 0) + 1);
        }

        long result = 0;
        long prevHorizontalLines = 0;

        for(int count: map.values()){

            long horizontalLines = (long) count * (count - 1) / 2;

            result = (result + horizontalLines * prevHorizontalLines) % M;

            prevHorizontalLines += horizontalLines;
        }

        return (int) (result % M);
    }
}