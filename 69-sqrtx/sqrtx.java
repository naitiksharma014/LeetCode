class Solution {
    public int mySqrt(int x) {
        //return (int) Math.pow(x , 0.5);
        if(x == 1 || x == 0) return x;

        int l = 1 , r = x / 2;
        int result = 0;

        while(l <= r){

            int mid = l + (r - l) / 2;
            
            long sq = (long)mid * mid;

            if(sq == x) return mid;
            else if(sq < x){
                result = mid;
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return result;
    }
}