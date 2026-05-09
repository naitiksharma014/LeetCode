class Solution {
    public String reverse(String s) {
        String reversed = "";

        for(int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }

        return reversed;
    }

    public String reverseWords(String s) {
        int n = s.length();
        String ans = new String();
        StringBuilder sb = new StringBuilder(s);

        s = reverse(s);

        for(int i = 0; i < n; i++) {

            String word = new String();

            while(i < n && s.charAt(i) != ' ') {
                word = word + s.charAt(i);
                i++;
            }

            word = reverse(word);

            if(word.length() > 0) {
                ans += ' ' + word;
            }
        }

        return ans.substring(1);
    }
}