class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        int count  = 1;

        StringBuilder st = new StringBuilder();
        st.append( s.charAt(0) );


        for( int i = 1 ; i < n ; i++ ){

            if( s.charAt( i - 1 ) == s.charAt( i ) ){
                count++;
            }
            else{
                count = 1;
            }

            if( count < 3 ){
                st.append( s.charAt(i) );
            }
        }

        return st.toString();
    }
}