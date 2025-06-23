class Solution {
    public boolean isPalindrome( String s ){
        int l = 0;
        int r = s.length()-1;

        while( l <= r){
            if( s.charAt(l++) != s.charAt(r--) )
               return false;
        }
        return true;
    }

    public String convertTobaseK( long num , int k ){
        if( num == 0 ) return "0";

        StringBuilder res = new StringBuilder();
        while( num > 0 ){
            res.append( num % k );
            num = num / k;
        }
        return res.toString();
    }   

    public long kMirror(int k, int n) {
        long sum = 0;
        int length = 1;

        while( n > 0 ){
            int halfLength = ( length + 1)/2;
            long minNum = (long)Math.pow( 10 , halfLength - 1);
            long maxNum = (long)Math.pow( 10 , halfLength ) - 1;

            for( long num = minNum ; num <= maxNum ; num++){
                String firstHalf = Long.toString( num );
                String secondHalf = new StringBuilder( firstHalf ).reverse().toString();

                String fullPalindrome;
                if( length % 2 == 0 ){
                    fullPalindrome = firstHalf + secondHalf;
                }
                else {
                    fullPalindrome = firstHalf + secondHalf.substring(1);
                }

                long palNum = Long.parseLong( fullPalindrome );
                String baseK = convertTobaseK( palNum , k );

                if( isPalindrome( baseK ) ){
                    sum += palNum;
                    n--;
                    if( n == 0 ) return sum;
                }
               
            }
            length++;
        }
        return sum;
    }
}