class Solution {
    public int countOdds(int low, int high) {
        //CASE 1: BOTH EVEN
        if(low % 2 == 0 && high % 2 == 0){
            return (high - low) / 2;
        } 
        

        //CASE 2: BOTH ODD
        //CASE 3: ODD & EVEN or EVEN & ODD
        return (high - low) / 2 + 1;
    }
}