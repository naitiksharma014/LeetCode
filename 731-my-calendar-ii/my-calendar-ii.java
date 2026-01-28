//Approach (Using Line Sweep)
//T.C : O(n)
//S.C : O(n) to store events in map

class MyCalendarTwo {
    private TreeMap<Integer, Integer> events = new TreeMap<>(); // Stores in sorted form
   
    public MyCalendarTwo() {
       
    }
    
    public boolean book(int startTime, int endTime) {
        events.put(startTime, events.getOrDefault(startTime, 0) + 1);
        events.put(endTime, events.getOrDefault(endTime, 0) - 1);

        int count = 0;

        for(int event: events.values()){

            count += event;

            if(count > 2){
                events.put(startTime, events.get(startTime) - 1);
                events.put(endTime, events.get(endTime) + 1);

                return false;
            }
        }

        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */