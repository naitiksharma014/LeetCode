//----------------------------------------------------------(APPROACH - 1)---------------------------------------------------------------------------------
// TC: O(num)



class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1) return true;
        
        int n = num / 2;

        for(int i = 1; i <= n; i++){

            if(i * i == num) return true;
        }

        return false;
    }
}



//----------------------------------------------------------(APPROACH - 2)---------------------------------------------------------------------------------
// TC: O(log n)
// Binary Search


class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 1){
            return true;
        }

        long low = 0, high = num / 2;

        while(low <= high){

            long mid = low + (high - low) / 2;

            long sq = mid * mid;

            if(sq == num){
                return true;
            }

            else if(sq < num){
                low = mid + 1;
            }

            else{
                high = mid - 1;
            }
        }

        return false;
    }
}




//----------------------------------------------------------(APPROACH - 3)---------------------------------------------------------------------------------
// TC: O(log n)
// Newton Method Code



class Solution {
    public boolean isPerfectSquare(int num) {
        long x = num;

        while (x * x > num) {
            x = (x + num / x) / 2;
        }

        return x * x == num;
    }
}


