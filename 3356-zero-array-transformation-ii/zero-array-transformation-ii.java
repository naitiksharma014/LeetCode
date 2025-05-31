class Solution {
    //  private int n=nums.length;
    //  private int q=queries.length;

    public boolean diffArray(int[] nums, int [][] queries, int k,int n, int q){
        //Difference Array
       int [] diff=new int[n];

       for(int i=0;i<=k;i++){
        int start=queries[i][0];
        int end=queries[i][1];
        int x=queries[i][2];

        diff[start]+=x;
        if(end+1<n) diff[end+1]-=x;
       } 

       //Cummutative / result
       
       int curr=0;
       for(int i=0;i<n;i++){
           curr+=diff[i];
           diff[i]=curr;

           if(nums[i]-diff[i]>0) return false;
       }

       return true;
    }
    
    public int minZeroArray(int[] nums, int[][] queries) {
       int n=nums.length;
       int q=queries.length;


       if (Arrays.stream(nums).allMatch(x -> x == 0)) {
            return 0; //no query required because all are already zero
        }

       int l=0;
       int r=q-1;
       int k=-1;
       while(l<=r){
        int mid=l+(r-l)/2;
        
        if(diffArray(nums,queries,mid,n,q)){
            k=mid+1;
            r=mid-1;

        } else {
            l=mid+1;
        }

       }
       
       return k;

       
    }
}