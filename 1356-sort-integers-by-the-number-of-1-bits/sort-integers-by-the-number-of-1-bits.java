class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        Integer[] temp = new Integer[n];

        for (int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }

        Arrays.sort(temp, (a, b) -> {

            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);

            // if both have same set bits
            if(countA == countB){
                return a - b;          // smaller number comes first
            }

            return countA - countB;     // otherwise sort by bit count
        });

        for (int i = 0; i < n; i++) {
            arr[i] = temp[i];
        }

        return arr;
    }
}