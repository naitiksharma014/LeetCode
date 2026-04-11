// ⏱️ TC:  O(n log n)
// 💾 SC: O(k)

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        int[][] pairs = new int[n][2];
        for(int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        // sort by nums2 descending
        Arrays.sort(pairs, (a, b)-> b[1] - a[1]);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long kSum = 0;

        for(int i = 0; i < k; i++) {
            kSum += pairs[i][0];
            minHeap.add(pairs[i][0]);
        }

        long result = kSum  * pairs[k - 1][1];

        for(int i = k; i < n; i++) {
            kSum += pairs[i][0] - minHeap.poll();

            minHeap.add(pairs[i][0]);

            result = Math.max(result, kSum * pairs[i][1]);
        }

        return result;
    }
}