// TC: O(2^m * (m + n))
// SC: O(m + n)

class Solution {
    int m, n;
    int result = Integer.MIN_VALUE;

    public void solve(int idx, int count, int n, int[][] requests, int[] resultant) {
        if(idx >= m) {

            boolean allZero = true;

            for(int r: resultant) {

                if(r != 0) {
                    allZero = false;
                }
            }

            if(allZero) {
                result = Math.max(result, count);
            }

            return;
        }

        int from = requests[idx][0];
        int to   = requests[idx][1];

        resultant[from]--;
        resultant[to]++;

        solve(idx + 1, count + 1, n, requests, resultant);

        resultant[from]++;
        resultant[to]--;

        solve(idx + 1, count, n, requests, resultant);

    }
    
    public int maximumRequests(int n, int[][] requests) {
        m = requests.length;

        int[] resultant = new int[n];

        solve(0, 0, n, requests, resultant);

        return result;
    }
}