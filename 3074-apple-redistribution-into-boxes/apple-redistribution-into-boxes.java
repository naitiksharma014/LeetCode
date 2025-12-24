class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n = apple.length;
        int m = capacity.length;

        Arrays.sort(capacity);

        int count = 0;
        int totalApple = 0;

        for(int i = 0; i < n; i++){

            totalApple += apple[i];
        }
        
        int i = m - 1;
        while(totalApple > 0){

            totalApple -= capacity[i];
            count++;
            i--;
        }

        return count;
    }
}