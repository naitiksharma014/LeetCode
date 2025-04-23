class Solution {

    public int SumDigit(int m){
        int sum=0;
        while(m>0){
            int s=m%10;
             sum+=s;
            m=m/10;

        }

        return sum;
    }
    public int countLargestGroup(int n) {
      int count=0;
      int maxSum=0;
      int[] arr=new int[37];

      for(int i=1;i<=n;i++){
        int d=SumDigit(i);
        arr[d]++;

        if(arr[d]==maxSum) count++;
         else if(arr[d]>maxSum){
            maxSum=arr[d];
            count=1;
        }

      }
      return count;

    }
}