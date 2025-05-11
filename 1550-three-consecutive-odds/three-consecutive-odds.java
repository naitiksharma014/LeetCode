class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int n=arr.length;
        int count=0;
        int i=1;
        while(i+1<n){
            if(arr[i-1]%2!=0 && arr[i]%2!=0 && arr[i+1]%2!=0)count++;
            i++;

            
        }
        if(count>0)return true;
        else return false;
        // return false;
    }
}