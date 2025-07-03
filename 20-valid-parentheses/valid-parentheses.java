class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>(); 

        for( char c : s.toCharArray() ){
            if( st.isEmpty() || c == '(' || c == '{' || c == '[' ){
                st.push( c );
                continue;
            }

            if( c == ')' ){
                if( st.peek() == '(' ){
                    st.pop();
                }
                else {
                    return false;
                }
            }

            else if( c == '}' ){
                if( st.peek() == '{' ){
                    st.pop();
                }
                else {
                    return false;
                }
            }

            else if( c == ']' ){
                if( st.peek() == '[' ){
                    st.pop();
                }
                else {
                    return false;
                }
            }
        }
        return st.isEmpty();

    }
}