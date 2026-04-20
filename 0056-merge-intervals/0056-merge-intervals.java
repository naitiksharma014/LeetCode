// Line Sweep Technique
// ⏱️ TC: O(n log n)
// 📦 SC: O(n)

class Solution {
    public int[][] merge(int[][] intervals) {
        Map<Integer, Integer> events = new TreeMap<>();

        for(int[] interval: intervals) {

            int start = interval[0];
            int end = interval[1];

            events.put(start, events.getOrDefault(start, 0) + 1);
            events.put(end, events.getOrDefault(end, 0) - 1);
        }

        int count = 0;
        int start = 0;
        List<int[]> overLapIntervals = new ArrayList<>();

        for (Map.Entry<Integer, Integer> event : events.entrySet()) {
            int key = event.getKey();
            int value = event.getValue();

            if(count == 0) {
                start = key; 
            }

            count += value;

            if(count == 0) {
                int end = key;
                
                overLapIntervals.add(new int[]{start, end});
            }
        }

        return overLapIntervals.toArray(new int[overLapIntervals.size()][]);
    }
}