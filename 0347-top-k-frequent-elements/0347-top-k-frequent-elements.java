// Time:  O(n + m log k)  ≈ O(n log k)
// Space: O(m + k)        ≈ O(n)

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        int[] res = new int[k];
        HashMap<Integer,Integer> freq = new HashMap<>();
        PriorityQueue<Integer> pq =
        new PriorityQueue<>((a,b) -> freq.get(a) - freq.get(b));

        for(int num: nums) {
            
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for(int num : freq.keySet()) {
            pq.offer(num);

            if(pq.size() > k) {
                pq.poll();
            }
        }

        int i = 0;
        while(!pq.isEmpty()) {
            res[i++] = pq.poll();
        }

        return res;
    }
}