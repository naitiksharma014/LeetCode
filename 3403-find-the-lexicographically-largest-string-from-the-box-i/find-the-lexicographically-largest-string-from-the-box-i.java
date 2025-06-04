class Solution {
    public String answerString(String word, int numFriends) {
        int n=word.length();

        if (numFriends == 1) {
            return word;
        }

        int possible=n-(numFriends-1);

        String result = "";

        for(int i=0;i<n;i++){
            int canTake = Math.min(possible,n-i);
            String sub = word.substring(i,i+canTake);
            if(sub.compareTo(result)>0){
                result = sub;
            }
        }
        return result;
    }
}