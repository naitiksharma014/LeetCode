// ⏱️ TC: O(n × k)
// 📦 SC: O(n)

class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if(ch != ']'){
                st.push(ch);
            }
            else {
                StringBuilder sb = new StringBuilder();
                
                while(!st.isEmpty() && st.peek() != '[') {
                    sb.append(st.pop());
                }

                sb.reverse();
                st.pop();     // remove '['

                // get number
                StringBuilder k = new StringBuilder();

                while(!st.isEmpty() && Character.isDigit(st.peek())) {
                    k.append(st.pop());
                }

                k.reverse();

                int num = Integer.parseInt(k.toString());

                // repeat string
                StringBuilder rep = new StringBuilder();

                for(int j = 0; j < num; j++) {
                    rep.append(sb);
                }

                // push back in stack
                for(char c: rep.toString().toCharArray()) {
                    st.push(c);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }
}