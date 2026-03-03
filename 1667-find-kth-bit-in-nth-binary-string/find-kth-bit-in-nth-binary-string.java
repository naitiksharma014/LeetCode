// TC = O(n)

class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';

        int len = (1 << n) - 1;    // (1 << n) : pow of 2
        int mid = (len + 1) / 2;

        if(k == mid) {
            return '1';
        } 
        else if(k < mid) {
            return findKthBit(n - 1, k);
        } 
        else {
            char ch = findKthBit(n - 1, len - k +  1);
            return ch == '1' ? '0' : '1';
        }
    }
}