class Solution {
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' ||
               ch == 'i' || ch == 'o' ||
               ch == 'u' ||
               ch == 'A' || ch == 'E' ||
               ch == 'I' || ch == 'O' ||
               ch == 'U';
    }

    public String reverseVowels(String s) {
        int n = s.length();
        int i = 0;
        int j = n - 1;
        char[] charArray = s.toCharArray();

        while (i < j) {
            if (!isVowel(charArray[i])) {
                i++;
            } else if (!isVowel(charArray[j])) {
                j--;
            } else {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                i++;
                j--;
            }
        }

        return new String(charArray);
    }
}