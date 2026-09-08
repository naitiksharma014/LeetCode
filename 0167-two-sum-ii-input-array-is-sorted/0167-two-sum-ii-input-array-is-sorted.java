// Outer loop: O(n)
// Binary search for each element: O(log n)

// Overall TC: O(n logn)

class Solution {
    public int binarySearch(int low, int t, int high, int[] numbers) {

        while(low <= high) {

            int mid = low + (high - low) / 2;

            while(low < high && numbers[low] == numbers[low + 1]) low++;
            while(low < high && numbers[high] == numbers[high - 1]) high--;

            if(numbers[mid] == t) {
                return mid;
            } else if(numbers[mid] < t) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int idx1 = -1, idx2 = -1;

        for(int i = 0; i < n; i++) {

            if(i != 0 && numbers[i] == numbers[i - 1]) continue;

            idx1 = i;
            idx2 = binarySearch(i + 1, target - numbers[i], n - 1, numbers);

            if(idx2 != -1) break;
        }

        return new int[]{idx1 + 1, idx2 + 1};
    }
}