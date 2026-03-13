// TC: O(n * log(Tmax))

class Solution {
    public boolean check(long mid, int mountainHeight, int[] workerTimes){
        long h = 0;

        for(int workerTime: workerTimes){
            
            h += (long) (Math.sqrt( 2.0 * mid / workerTime + 0.25 ) - 0.5);

            if(h >= mountainHeight){
                return true;
            }
        }

        return h >= mountainHeight;
    }
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long n = workerTimes.length;

        long Tmax = -1;
        for(int workerTime: workerTimes){
            Tmax = (long) Math.max(workerTime, Tmax);
        }

        long l = 1, r = Tmax * mountainHeight * (mountainHeight + 1) / 2;
        long result = -1;

        while(l <= r){

            long mid = l + (r - l) / 2;

            if (check(mid, mountainHeight, workerTimes)){
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }
}