class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
        int count = 0;

        while(i < n && (i + 1) < n){

            if( (bits[i] == 1 && bits[i+1] == 0) || (bits[i] == 1 && bits[i+1] == 1) ){
                count += 2;
                i += 2;
            }
            else{
                count++;
                i++;
            }
        }

        if(count == n) return false;
        if(bits[n-1] == 1) return false;

        return true;
    }
}