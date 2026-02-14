class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        Map<Long, Long> events = new TreeMap<>();
        List<List<Long>> result = new ArrayList<>();

        for(int[] segment: segments){

            long start = segment[0];
            long end   = segment[1];
            long color = segment[2];

            events.put(start, events.getOrDefault(start, 0L) + color);
            events.put(end  , events.getOrDefault(end  , 0L) - color);
        }
        
        // Long can be NULL and long cannot be
        Long prev = null;   
        long event = 0;

        for(long start: events.keySet()){

            if(prev != null && event > 0){
                result.add(Arrays.asList(prev, start, event));
            }

            prev = start;
            event += events.get(start);
        }

        return result;
    }
}