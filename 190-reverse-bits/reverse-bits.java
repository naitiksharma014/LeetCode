class Solution {
    public int reverseBits(int n) {
        int res = 0;

        for(int i = 1; i < 33; i++){

            res <<= 1;         // shift result left to make space for next
            
            int x = (n & 1);   // Find Most Significant Bit (MSB)

            res = res | x;     // Append MSB into result

            n >>= 1;          // shift n right
        }

        return res;
    }
}