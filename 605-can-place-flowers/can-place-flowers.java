class Solution {
    public boolean canPlaceFlowers(int[] m, int n) {
       
       if(n==0) return true;

       for(int i=0;i<m.length;i++){
        if(m[i]==0 && (i==0 || m[i-1]==0) && (i==m.length-1 || m[i+1]==0)){
            m[i]=1;
            n--;

            if(n==0){
                return true;
            }
        }
       }
       return false;

    }
}