// TC = O(n · 2ⁿ) × O(n) = O(n² · 2ⁿ)​

class Solution {
    int n;
    List<String> curr = new ArrayList<>();
    List<List<String>> result = new ArrayList<>();

    public boolean isPalindrome(String s, int start, int end) {
    
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public void solve(String s, int idx) {
        if(idx == n) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx; i < n; i++) {

            if(isPalindrome(s, idx, i)) {
                curr.add(s.substring(idx, i + 1));


                solve(s, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        n = s.length();

        solve(s, 0);

        return result;
    }
}