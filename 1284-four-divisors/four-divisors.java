class Solution {
    public int findSumDivisors(int num){
        int divisorCount = 0;
        int sum = 0;

        for(int fact = 1; fact * fact <= num; fact++){
           
            if(num % fact == 0){
                int other = num / fact;

                if(other == fact){
                    divisorCount++;
                    sum += fact;
                }
                else{
                    divisorCount += 2;
                    sum += (fact + other);
                }   
            }

            if(divisorCount > 4){
                return 0;
            }
        }

        return divisorCount == 4? sum: 0;
    }

    public int sumFourDivisors(int[] nums) {
        int result = 0;

        for(int num: nums){

            result += findSumDivisors(num);
        }

        return result;
    }
}