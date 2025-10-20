-------------------------------------------------------------------------( APPROACH - 1 )----------------------------------------------------

    
class Solution {
    public String removeStars(String s) {
        char[] arr = new char[s.length()];
        int i = 0;

        for(char ch : s.toCharArray()){
            if(ch == '*'){
                if(i > 0) i--;
            }
            else{
                arr[i++] = ch;
            }
        }
        return new String(arr , 0 , i);
    }
}





-------------------------------------------------------------------------( APPROACH - 2 )----------------------------------------------------


    
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
