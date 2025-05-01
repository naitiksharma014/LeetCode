class Solution {
    public boolean isPalindrome(int x) {
        int temp=x;
        int t;
        int reverse=0;
        if(x<0){
            return false;
        }
        else{
            while(x>0){
                t=x%10;
                reverse=reverse*10+t;
                x=x/10;
            }
            if(reverse==temp){
                return true;
            }

        }
        return false;

    }
}