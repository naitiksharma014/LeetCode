class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int totalTime=0;

        for(int i = 0; i < n; i++){
           
            if (i > 0 && colors.charAt(i) == colors.charAt(i - 1)) {
                
                totalTime += Math.min(neededTime[i], neededTime[i - 1]);
               
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }

        return totalTime;
    } 
}