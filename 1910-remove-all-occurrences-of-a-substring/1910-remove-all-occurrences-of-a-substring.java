// TC: O(m * n)
// SC: O(n)

class Solution {
    public String removeOccurrences(String s, String part) {
        int n = s.length();
        int m = part.length();

        StringBuilder sb = new StringBuilder();

        for(char ch: s.toCharArray()) {

            sb.append(ch);

            if(sb.length() >= m) {

                // Check last m char
                String last = sb.substring(sb.length() - m);

                // if equals then remove
                if(last.equals(part)) {
                    sb.delete(sb.length() - m, sb.length());
                }
            }
        }

        return sb.toString();
    }
}