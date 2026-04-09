// ⏱️ TC: O(n log k)
// 📦 SC: O(k)

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num: nums) {         // O(n)

            pq.add(num);            // O(log k) 
            if(pq.size() > k) {
                pq.remove();        // O(log k)
            }
        }

        return pq.peek();
    }
}