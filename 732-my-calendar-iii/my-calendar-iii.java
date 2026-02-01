class MyCalendarThree {
    Map<Integer, Integer> events = new TreeMap<>();
    public MyCalendarThree() {
       
    }
    
    public int book(int startTime, int endTime) {
        events.put(startTime, events.getOrDefault(startTime, 0) + 1);
        events.put(endTime, events.getOrDefault(endTime, 0) - 1);

        int count = 0, Mcount = Integer.MIN_VALUE;

        for(int event: events.values()){
            count += event;

            Mcount = Math.max(Mcount, count);
        }

        return Mcount;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */