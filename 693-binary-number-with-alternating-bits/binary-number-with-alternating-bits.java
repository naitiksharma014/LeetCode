//----------------------------------------------------------------------(Approach - 1)-----------------------------------------------------------------
// TC: O(log n)
// SC: O(log n)


class Solution {
    public boolean hasAlternatingBits(int n) {
        String bits = Integer.toBinaryString(n);

        for(int i = 0; i < bits.length() - 1; i++){

            if(bits.charAt(i) == bits.charAt(i + 1)){
                return false;
            }
        }

        return true;

    }
}



//----------------------------------------------------------------------(Approach - 2)-----------------------------------------------------------------
// TC: O(log n)
// SC: O(1)


class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = -1;

        while(n > 0){

            int curr = n % 2;
            if(prev == curr) return false;
            prev = curr;
            n = n / 2;
        }

        return true;
    }
}



//----------------------------------------------------------------------(Approach - 3)-----------------------------------------------------------------
// TC: O(1)
// SC: O(1)

class Solution {
    public boolean hasAlternatingBits(int n) {
        int x = n ^ (n >>> 1);  // unsigned shift
        return (x & (x + 1)) == 0;
    }
}


