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