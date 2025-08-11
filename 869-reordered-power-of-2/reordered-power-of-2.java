class Solution {
    public String getSorted(int n ){
        char ch[] = String.valueOf(n).toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    public boolean reorderedPowerOf2(int n) {
        String s = getSorted(n);

        for( int p=0 ; p<=29 ; p++ ){
            if( s.equals( getSorted(1<<p)) ){
                return true;
            }
        }
        return false;    
    }
}