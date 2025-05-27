class Solution {
    public int differenceOfSums(int n, int m) {
       int val1=n*(n+1)/2;
       int i=m;
       int val2=0;
       if(m==1){
        return 0-val1;
       }
       
       while(i<=n){
        
         val2 +=i;
         i+=m;
        
       } 

       return  val1-2*val2;
    }
}