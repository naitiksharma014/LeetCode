class Solution {
    public int totalMoney(int n) {
        int sum = 0;
        int mon = 1;
        int day = 1;

       for(int i = 1 ; i <= n ; i++){
           if(i != 1 && i % 7 == 1){
               mon++;
               day = mon;
            }

            
            sum += day;
            day++;

        }

        return sum;  
    }
}