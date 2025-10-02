class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = numBottles;
        int emptyBottles = numBottles;

        while(emptyBottles >= numExchange){
            emptyBottles -= numExchange;
            numExchange += 1;
            res += 1;
            emptyBottles += 1;
        }
        return res;
    }
}