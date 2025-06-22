class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        ArrayList<String> result = new ArrayList<>();
        int i = 0;
      
        while( i < n ){
            int end = Math.min( i + k , n ); 
            StringBuilder gp = new StringBuilder( s.substring( i , end  ));
            
            while( gp.length() < k ){
               gp.append( fill );
            }
            
            result.add( gp.toString() );
            i += k;
        }
        return result.toArray( new String[0] );

    }
}