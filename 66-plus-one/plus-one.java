class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for(int i = n - 1 ; i >= 0 ; i--){

            if(digits[i] < 9){
                digits[i]++;
                break;
            }    
            else digits[i] = 0;
        }
        
        int[] arr = new int[n + 1];
        if(digits[0] == 0){
           
           arr[0] = 1;
           for(int i = 1 ; i < n + 1 ; i++){
                
                arr[i] = digits[i - 1];
            }
            return arr;

        }
        return digits;
    }
}