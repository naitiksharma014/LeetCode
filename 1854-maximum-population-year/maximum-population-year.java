// Sweep Line
class Solution {
    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> events = new TreeMap<>();

        for(int[] log: logs){

            int birth = log[0];
            int death = log[1];

            events.put(birth, events.getOrDefault(birth, 0) + 1);
            events.put(death, events.getOrDefault(death, 0) - 1);
        }
        
        int maxPopulation = Integer.MIN_VALUE;
        int earliestYear = -1;
        int event = 0;

        for(int year: events.keySet()){
           
           event += events.get(year);

            if(event > maxPopulation){
                maxPopulation = event;
                earliestYear = year;
            }
        }

        return earliestYear;
    }
}