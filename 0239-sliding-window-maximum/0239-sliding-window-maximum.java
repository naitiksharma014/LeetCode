// Sliding window + Deque
// TC: O(n)
// SC: O(k)

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deq = new ArrayDeque<>();

        for(int i = 0; i < k; i++) {
            while(!deq.isEmpty() && nums[deq.peekLast()] <= nums[i]) {
                deq.pollLast();
            }
            deq.offerLast(i);
        }
        
        int j = 0;
        for(int i = k; i < n; i++) {
            res[j++] = nums[deq.peekFirst()];

            // remove out of bound elements
            while(!deq.isEmpty() && deq.peekFirst() <= i - k) {
                deq.pollFirst();
            }

            // remove smaller elements
            while(!deq.isEmpty() && nums[deq.peekLast()] <= nums[i]) {
                deq.pollLast();
            }
            deq.offerLast(i);
        }
        res[j] = nums[deq.peekFirst()];

        return res;
    }
}