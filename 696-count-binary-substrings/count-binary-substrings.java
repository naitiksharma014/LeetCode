class Solution {
    public int countBinarySubstrings(String s) {
        int n = s.length();
        int currCount = 1, prevCount = 0, count = 0;

        for(int i = 1; i < n; i++){

            if(s.charAt(i - 1) == s.charAt(i)){
                currCount++;
            }
            else{
                count += Math.min(currCount, prevCount);
                prevCount = currCount;
                currCount = 1;
            }
        }

        return count + Math.min(currCount, prevCount);
    }
}