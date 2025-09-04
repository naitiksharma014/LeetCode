class Solution {
    public int findClosest(int x, int y, int z) {
        int x1 = Math.abs(z - x);
        int y2 = Math.abs(z - y);

        if(x1 == y2) return 0;
        if(x1 < y2) return 1;
        return 2;
    }
}