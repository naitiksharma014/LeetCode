// 📦 SC: O(n)

class SmallestInfiniteSet {
    int curr;
    PriorityQueue<Integer> pq;
    Set<Integer> set = new HashSet<>();

    public SmallestInfiniteSet() {     // O(log n)
        curr = 1;
        pq = new PriorityQueue<>();
        set = new HashSet<>();    
    }
    
    public int popSmallest() {         // O(log n)
        if(!pq.isEmpty()) {
            int val = pq.poll();
            set.remove(val);

            return val;
        }

        return curr++;
    }
    
    public void addBack(int num) {
        if(num < curr && !set.contains(num)) {
            set.add(num);
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */