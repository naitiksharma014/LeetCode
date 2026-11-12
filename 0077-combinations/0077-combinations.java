// Time Complexity: O(k * C(n, k))

// Space Complexity:
// - Auxiliary Space: O(k)
// - Output Space: O(k * C(n, k))
// - Total Space: O(k * C(n, k))

class Solution {

    List<Integer> currList = new ArrayList<>();
    List<List<Integer>> resultList = new ArrayList<>();

    public void solve(int idx, int n, int k) {
        if(currList.size() == k) {
            resultList.add(new ArrayList<>(currList));
            return;
        }

        for(int i = idx; i <= n; i++) {

            currList.add(i);

            solve(i + 1, n, k);

            currList.remove(currList.size() - 1);
            
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        solve(1, n, k);
        return resultList;
    }
}