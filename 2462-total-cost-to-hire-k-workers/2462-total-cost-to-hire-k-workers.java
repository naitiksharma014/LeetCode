// TC: O(nlogc + klogc) ≈ O(n log c)
// SC: O(candidates)

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        int i = 0, j = n - 1;
        long ans = 0;

        while(k--> 0) {

            while(pq1.size() != candidates && i <= j) {
                pq1.add(costs[i++]);
            }

            while(pq2.size() != candidates && j >= i) {
                pq2.add(costs[j--]);
            }

            int a = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
            int b = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

            if(a <= b) {
                ans += a;
                pq1.poll();

            } else {
                ans += b;
                pq2.poll();

            }
        }

        return ans;
    }
}