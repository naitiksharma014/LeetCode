class Solution {
    public int differenceOfSums(int n, int m) {
      int k=n/m;
      int divisiblebym=m*k*(k+1)/2;
      int totalsum=n*(n+1)/2;

      return totalsum-2*divisiblebym;
    }
}