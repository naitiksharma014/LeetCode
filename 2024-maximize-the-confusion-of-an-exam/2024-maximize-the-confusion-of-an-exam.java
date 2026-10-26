// Time Complexity: \(O(n)\) — two calls to solve(), each traverses the string once.
// Space Complexity: \(O(1)\) — only a constant number of extra variables are used.

class Solution {
    public int solve(String s, int k, char flag) {
        int n = s.length();
        int count = 0;
        int ans = 0;
        int j = 0;

        for(int i = 0; i < n; i++) {

            char ch = s.charAt(i);
            if(ch == flag) {
                count++;
            }

            while(count > k) {

                if(s.charAt(j) == flag) {
                    count--;
                }

                j++;
            }

            ans = Math.max(ans, i - j + 1);
        }

        return ans;
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int trueLen = solve(answerKey, k, 'T');
        int falseLen = solve(answerKey, k, 'F');

        return Math.max(trueLen, falseLen);
    }
}