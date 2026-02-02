//-------------------------------------------------------------------------- (APPROACH - 1)---------------------------------------------------------------------------------------------------------------
// Line Sweep Technique
// Time Complexity = O(N log N) 
// Space Complexity = O(N)


class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int m = trips.length;
        int n = trips[0].length;

        Map<Integer, Integer> events = new TreeMap<>();

        for(int[] trip: trips){

            int numPassengers = trip[0];
            int from          = trip[1];
            int to            = trip[2];

            events.put(from, events.getOrDefault(from, 0) + numPassengers);
            events.put(to, events.getOrDefault(to, 0) - numPassengers);
        }


        int totalCapacity = 0;

        for(int event: events.values()){

            totalCapacity += event;

            if(totalCapacity > capacity){
                return false;
            }
        }

        return true;
    }
}




//-------------------------------------------------------------------------- (APPROACH - 2)---------------------------------------------------------------------------------------------------------------
// Difference Array
// Time Complexity = O(N)
// Space Complexity = O(1001) = O(1)




class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int m = trips.length;
        int n = trips[0].length;

        int[] diffArray = new int[1001];

        for(int[] trip: trips){

            int numPassengers = trip[0];
            int from          = trip[1];
            int to            = trip[2];

            diffArray[from] += numPassengers;
            diffArray[to] -= numPassengers;
        }


        int totalCapacity = 0;

        for(int i = 0; i < 1001; i++){

            totalCapacity += diffArray[i];

            if(totalCapacity > capacity){
                return false;
            }
        }

        return true;
    }
}
