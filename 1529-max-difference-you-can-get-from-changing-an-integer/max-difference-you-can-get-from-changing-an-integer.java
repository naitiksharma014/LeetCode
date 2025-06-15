class Solution {
    public int maxDiff(int num) {
        String str1 = Integer.toString( num );
        String str2 = str1;
        int idx = 0;

        int n = str1.length();

        for( int i=0 ; i<n ; i++ ){
            if( str1.charAt(i) != '9' ){
                idx = i;
                break;
            }
        }

        if( idx != -1 ){
            str1 = str1.replace( str1.charAt(idx) , '9' );
        }

        // MINIMUM
        for( int i=0 ; i<n ; i++ ){
            char ch = str2.charAt(i);

            if( i==0 ){
                if( ch != '1' ){
                    str2 = str2.replace( ch , '1' );
                    break;
                }
            }
            else if( ch !='0' && ch != str2.charAt(0) ){
                str2 = str2.replace( ch , '0' );
                break;
            }
        }

        return Integer.parseInt( str1 ) - Integer.parseInt( str2 );
    }
}