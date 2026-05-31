// TC: O(n * log n)

class Solution {
  
    public int maxValue(int[] quantities) {
        int max = Integer.MIN_VALUE;

        for(int quantity  : quantities) {
            max = Math.max(max, quantity );
        }


        return max;
    } 

    public boolean isPossible(int[] quantities, int mid, int n) {
        long storesNeeded = 0;

        for(int quantity  : quantities) {
            storesNeeded += (quantity + mid - 1) / mid;

            if(storesNeeded > n) {
                return false;
            }
        }

        return true;
    }

    public int minimizedMaximum(int n, int[] quantities) {
        int l = 1, r = maxValue(quantities);
        int result = -1;

        while(l <= r) {

            int mid = l + (r - l) / 2;

            if(isPossible(quantities, mid, n)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }
}