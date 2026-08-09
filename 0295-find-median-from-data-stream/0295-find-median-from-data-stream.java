// Time:
//   addNum()     -> O(log n)
//   findMedian() -> O(1)

// Space: O(n)

class MedianFinder {

    PriorityQueue<Integer> left_max;   // max heap
    PriorityQueue<Integer> right_min;  // min heap

    public MedianFinder() {
        left_max = new PriorityQueue<>(Collections.reverseOrder());
        right_min = new PriorityQueue<>();
    }
    
    public void addNum(int num) {    // O(log n)

        if(left_max.isEmpty() || num < left_max.peek()) {
            left_max.add(num);
        } else {
            right_min.add(num);
        }

        // Check
        if(left_max.size() - right_min.size() > 1) {
            right_min.add(left_max.poll());
        } else if(right_min.size() > left_max.size()){
            left_max.add(right_min.poll());
        }
    }
    
    public double findMedian() {    // O(1)

        if(left_max.size() == right_min.size()) {
            return (left_max.peek() + right_min.peek()) / 2.0;
        }

        return left_max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */