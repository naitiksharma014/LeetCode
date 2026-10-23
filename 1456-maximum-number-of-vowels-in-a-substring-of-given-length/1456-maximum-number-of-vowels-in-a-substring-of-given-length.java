// TC = O(n)
// SC = O(1)

class Solution {
    public boolean isVowel(char ch) {
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
            return true;
        }

        return false;
    }

    public int maxVowels(String s, int k) {
        int n = s.length();

        int maxCount = Integer.MIN_VALUE;
        int i = 0, j = 0;
        int count = 0;

        while(j < n) {

            char ch = s.charAt(j);
            if(isVowel(ch)) {
                count++;
            }

            if(j - i + 1 == k) {
                
                maxCount = Math.max(maxCount, count);

                char prevCh = s.charAt(i);
                if(isVowel(prevCh)) {
                    count--;
                }

                i++;
            }

            j++;
        }

        return maxCount == Integer.MIN_VALUE ? 0 : maxCount;
    }
}