class Solution {
    public boolean canEatPiles(int[] piles, int mid, int h){
        int hour = 0;

        for(int pile : piles){

            hour += pile / mid;

            if(pile % mid != 0){
                hour++;
            }
        }

        return hour <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Integer.MAX_VALUE;

        while(l < r){

            int mid = l + (r - l)/2;

            if(canEatPiles(piles, mid, h)){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }

        return l;
    }
}