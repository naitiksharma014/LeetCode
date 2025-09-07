class Solution {
    public int[] sumZero(int n) {
       int[] arr = new int[n];
       int elem = 1;

       for(int i = 0 ; i < n ; i++){
           arr[i] = 0;
        }
        int i = 0;
        while(i < n - 1){
            arr[i] = elem;
            arr[i+1] = - elem;

            i = i + 2;
            elem++;
        } 

        return arr;
    }
}