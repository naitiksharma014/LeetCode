// TC: O(log x) 

class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        int low = 1, high = x / 2, mid = 0;

        while(low <= high) {

            mid = low + (high - low) / 2;
            long square = (long) mid * mid;

            if(square == x) {
                return mid;
            }
            else if(square < x) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return high;
    }
}