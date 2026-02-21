// TC: O(right - left + 1)
// SC: O(1)

class Solution {
    public boolean isPrime(int n){
        if(n < 2) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;

        for(int i = 3; i * i <= n; i += 2){

            if(n % i == 0) return false;
        }

        return true;
    }

    public int countPrimeSetBits(int left, int right) {
        int count = 0;

        for(int i = left; i <= right; i++){   //O(right - left + 1)

            int n = Integer.bitCount(i);      // O(1)

            if(isPrime(n)){                   // TC: O(√n) → O(√32) → O(1)
                count++;
            }
        }

        return count;
    }
}