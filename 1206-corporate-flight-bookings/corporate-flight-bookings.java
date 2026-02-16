//--------------------------------------------------------(Approach - 1)-------------------------------------------------------------------------
// Line Sweep Technique
// TC: O(N log M)
// SC: O(M)

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        Map<Integer, Integer> events = new TreeMap<>();

        for(int[] booking: bookings){

            int start = booking[0];
            int end  = booking[1];
            int seat  = booking[2];

            events.put(start, events.getOrDefault(start, 0) + seat);
            events.put(end + 1, events.getOrDefault(end + 1, 0) - seat);
        }

        int[] result = new int[n];
        int currSum = 0;

        for(int flight = 1; flight <= n; flight++){
            
            if(events.containsKey(flight)){
                currSum += events.get(flight);
            }
            
            result[flight - 1] = currSum;
        } 

        return result;     
    }
}




//--------------------------------------------------------(Approach - 2)-------------------------------------------------------------------------
// Difference Array
// Time: O(M + N) 
// Space: O(N)
 
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diffArray = new int[n + 2];

        for(int[] booking: bookings){

            int start = booking[0];
            int end   = booking[1];
            int seat  = booking[2];

            diffArray[start]   += seat;
            diffArray[end + 1] -= seat;
        }

        int[] result = new int[n];
        int currSum = 0;

        for(int i = 1; i <= n; i++){

            currSum += diffArray[i];
            result[i - 1] = currSum;
        }

        return result;
    }
}
