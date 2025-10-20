class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int x = 0;

        for(String ch : operations){
            if (ch.equals("++X") || ch.equals("X++")) x += 1;
            if (ch.equals("--X") || ch.equals("X--")) x -= 1;
        }
        return x;
    }
}