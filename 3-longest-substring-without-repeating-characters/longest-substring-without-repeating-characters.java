class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0 , e = 0;
        List<Character> list = new ArrayList<>();
        int max = 0;

        while( e < s.length() ){
            if( !list.contains(s.charAt(e)) ){
                list.add( s.charAt(e) );
                max = Math.max( max , list.size() );
                e++;
            }

            else{
                list.remove( Character.valueOf(s.charAt(l)) ); // Character.valueOf is used otherwise it will remove skyvalue
                l++;
            }
        }
        return max;   
    }
}