class Solution {
    public String largestGoodInteger(String nums) {
        char max = ' ';
        int n = nums.length();

        for( int i=2 ; i<n ; i++ ){
            if( nums.charAt(i) == nums.charAt(i-1) && nums.charAt(i-2) == nums.charAt(i)){
                char ch = nums.charAt(i);
                max = (char) Math.max( max , ch );
            }
        }
        String str = new String( new char[] { max , max , max } );

        if( max == ' ') return "";
        return str;



    }
}