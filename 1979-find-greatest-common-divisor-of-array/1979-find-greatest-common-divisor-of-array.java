// TC: O(n + n + log(max)) = O(n)
// SC: O(1)

class Solution {

    public int findGCD(int a, int b) {
        while(b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    public int findGCD(int[] nums) {
        int n = nums.length;

        int max = Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;

        // Find Min & Max
        for(int num: nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        // Euclidean Algorithm → O(log(min, max))
        int gcd = findGCD(min, max);

        return gcd;
    }
}