class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
      int n=s.length();

      //1 Create Difference Array 
      int difference[]=new int [n];

      for(int[] shift:shifts) {
        int start=shift[0];
        int end=shift[1];
        int x;
        if(shift[2]==0)x=-1;
        else x=1;

         difference[start]+=x;
         if(end+1<n) difference[end+1]-=x;
      } 

      //S2 Cummutative array
      for(int i=1;i<n;i++){
        difference[i]+=difference[i-1];
      }

      //S3 Find value
      StringBuilder result=new StringBuilder(s);
      for(int i=0;i<n;i++){
       
        int shift=difference[i]%26;
         shift=shift%26;
        if(shift<0) shift=shift+26;

      char newChar=(char)(((result.charAt(i)-'a' + shift) %26) +'a');
      result.setCharAt(i,newChar);
      }

      return result.toString();
      


      
    }
   
}