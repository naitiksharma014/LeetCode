class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;

        for(String ch : operations){
            if (ch.charAt(1) == '+') x ++;
            else x --;
        }
        return x;
    }
}