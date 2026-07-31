// TC:
// Constructor: O(n log k)
// add(): O(log k)

// SC: O(k)

class KthLargest {
    
    int K;
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        K = k;

        for(int num: nums) {
            minHeap.add(num);   // O(log h), h = current heap size

            if(minHeap.size() > k) {
                minHeap.poll();     // O(log k), 
            }
        }    
    }
    
    public int add(int val) {
        minHeap.add(val);   // O(log h), h = current heap size

        if(minHeap.size() > K) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */