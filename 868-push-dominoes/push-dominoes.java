class Solution {
    public String pushDominoes(String dominoes) {
        String s = "L" + dominoes + "R";
        int n = s.length();
        StringBuilder result = new StringBuilder();

        for (int i = 0, j = 1; j < n; j++) {
            if (s.charAt(j) == '.') continue;

            int midPartLength = j - i - 1;
            if (i > 0)
                result.append(s.charAt(i));

            if (s.charAt(i) == s.charAt(j))
                result.append(String.valueOf(s.charAt(i)).repeat(midPartLength));
            else if (s.charAt(i) == 'L' && s.charAt(j) == 'R')
                result.append(".".repeat(midPartLength));
            else {
                int half = midPartLength / 2;
                result.append("R".repeat(half));
                if (midPartLength % 2 == 1) result.append('.');
                result.append("L".repeat(half));
            }

            i = j;
        }

        return result.toString();
    }
}