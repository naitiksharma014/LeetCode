// TC: O(n)
// SC: O(n)

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        int i = 0;

        while(i < n) {

            char ch = s.charAt(i);

            if(ch == ')') {

                if(st.isEmpty() || st.peek() != '(') {
                    return false;
                }
                else {
                    st.pop();
                }
            }
            else if(ch == '}') {

                if(st.isEmpty() || st.peek() != '{') {
                    return false;
                }
                else {
                    st.pop();
                }
            }
            else if(ch == ']') {

                if(st.isEmpty() || st.peek() != '[') {
                    return false;
                }
                else {
                    st.pop();
                }
            }
            else {
                st.push(ch);    // '(', '{', '[' -> only these should be push into Stack 
            }

            i++;
        }

        return st.isEmpty();
    }
}