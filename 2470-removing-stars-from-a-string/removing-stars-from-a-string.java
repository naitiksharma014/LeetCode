class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '*'){
                st.pop();
            }
            if(ch != '*'){
                st.push(ch);
            }
        }
        StringBuilder res = new StringBuilder();
        
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        
        return res.reverse().toString();
    }
}