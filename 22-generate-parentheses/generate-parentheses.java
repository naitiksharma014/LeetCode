//-------------------------------------------------------------- ( APPORACH - 1) ----------------------------------------------------------------------------
// TC: O(n * 4 ^ n)
// SC: O( n)


class Solution {
    List<String> list = new ArrayList<>();
    public boolean isValid(StringBuilder s){
        Stack<Character> st = new Stack<>();

        if(s.charAt(0) == ')') return false;

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(ch == '('){
                st.push(ch);
            }
            else{
                if(st.isEmpty()) return false;

                st.pop();
            }
        }

        return st.isEmpty();
    }

    public void solve(int len, StringBuilder s){
        if(len == 0){

            if(isValid(s)){
                list.add(s.toString());
            }

            return;
        }

        solve(len - 1, new StringBuilder(s).append('('));
        solve(len - 1, new StringBuilder(s).append(')'));
    }

    public List<String> generateParenthesis(int n){

        solve(2 * n, new StringBuilder());   

        return list; 
    }
}










    
//---------------------------------------------------------------( APPORACH - 2)-----------------------------------------------------------------------------
// TC: O( (4 ^ n) / sq. root(n) ) 
// Sc: O(n)



class Solution {
    List<String> list = new ArrayList<>();

    public void solve(int n, int open, int close, StringBuilder s){
        if(s.length() == n *2){
            list.add(s.toString());
            return;
        }
        
        // Option 1: Add '(' if we still can
        if(open < n){

            s.append('(');                      // Choose
            solve(n, open + 1, close, s);       // Explore
            s.deleteCharAt(s.length() - 1);     // Backtrack (Undo)
        }
        
        // Option 2: Add ')' only if it will remain valid
        if(close < open){

            s.append(')');                      // Choose
            solve(n, open, close + 1, s);       // Explore
            s.deleteCharAt(s.length() - 1);     // Backtrack
        }
    }

    public List<String> generateParenthesis(int n) {
        solve(n, 0, 0, new StringBuilder());

        return list;
    }
}
