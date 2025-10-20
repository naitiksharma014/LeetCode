class Solution {
    public String removeStars(String s) {
        char[] arr = new char[s.length()];
        int i = 0;

        for(char ch : s.toCharArray()){
            if(ch == '*'){
                if(i > 0) i--;
            }
            else{
                arr[i++] = ch;
            }
        }
        return new String(arr , 0 , i);
    }
}