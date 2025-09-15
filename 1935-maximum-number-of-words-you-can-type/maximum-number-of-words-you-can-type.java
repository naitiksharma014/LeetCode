class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int count = 0;
        boolean canType = true;

        boolean[] map = new boolean[26];

        for(char ch : brokenLetters.toCharArray()){
            map[ch - 'a'] = true;
        }
        
        for(char ch : text.toCharArray()){

            if(ch == ' '){
                if(canType) count++;

                canType = true;
            }

            else if(map[ch - 'a'] == true) canType = false;
        }

        // Last case will miss out
        if(canType) count++;

        return count;
    }
}