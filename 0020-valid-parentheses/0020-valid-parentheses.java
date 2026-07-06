// TC: O(n)
// SC: O(n)

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            
            char ch = s.charAt(i);

            if(ch == ')') {
                if(st.isEmpty() || st.pop() != '(') {
                    return false;
                }
            }
            else if(ch == '}') {
                
                if(st.isEmpty() || st.pop() != '{') {
                    return false;
                }
            }
            else if(ch == ']') {

                if(st.isEmpty() || st.pop() != '[') {
                    return false;
                }
            } 
            else {
                st.push(ch);
            }
        }

        return st.isEmpty();
    }
}