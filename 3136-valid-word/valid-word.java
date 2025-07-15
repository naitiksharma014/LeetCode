class Solution {
    public boolean isVowel(char x)
    {
        if (x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u' ){
                return true;
        }
        return false;
    }

    public boolean isValid(String word) {
       int n = word.length();
       int vol = 0;
       int cons = 0;
     
       if( n < 3 ){
        return false;
       } 
       
       for( int i = 0 ; i < n ; i++ ){
          char ch = word.charAt(i);

          if( Character.isLetter( ch ) ){
             ch = Character.toLowerCase( ch );
            if( isVowel( ch ) ){
                vol++;
            }
            else{
                cons++;
            }
          }
          else if( !Character.isDigit( ch ) ){
              return false;
          }
       }

       if( vol > 0 && cons > 0 ){
        return true;
       }
       return false;
    }
}