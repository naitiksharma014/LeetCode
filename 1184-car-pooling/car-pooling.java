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