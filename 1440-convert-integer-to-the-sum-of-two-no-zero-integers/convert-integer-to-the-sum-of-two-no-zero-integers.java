class Solution {
    public boolean isZero(int n){
        if(n % 10 == 0) return false;
        while(n > 0){
            if(n % 10 == 0) return false;
            n = n / 10;
        }
        return true;
    }
    public int[] getNoZeroIntegers(int n) {
        int[] arr = new int[2];

       for(int i = 1 ; i < n ; i++){
           int a = i;
           int b = n - i;

           if(isZero(a) && isZero(b)){
              arr[0] = a;
              arr[1] = b;
              return arr;
            }
        }
        return arr;
    }
}