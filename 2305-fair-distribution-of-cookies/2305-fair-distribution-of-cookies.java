// Complexity	Value
// Time:  O(kⁿ * k)
// Space: O(n + k)

class Solution {
    int n;
    int result = Integer.MAX_VALUE;

    public int findMax(int[] children) {
        int max = Integer.MIN_VALUE;

        for(int child: children) {
            max = Math.max(max, child);
        }

        return max;
    }

    public void solve(int idx, int[] children, int[] cookies, int k) {
        if(idx >= n) {
            int maxChild = findMax(children);
            result = Math.min(result, maxChild);
            return;
        }

        int cookie = cookies[idx];

        for(int i = 0; i < k; i++) {

            children[i] += cookie;

            solve(idx + 1, children, cookies, k);

            children[i] -= cookie;
        }
    }

    public int distributeCookies(int[] cookies, int k) {
        n = cookies.length;
        int[] children = new int[k];

        solve(0, children, cookies, k);

        return result;
    }
}