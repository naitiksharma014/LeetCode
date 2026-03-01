class Solution {
    public int minPartitions(String n) {
        char max = '0';

        for(char ch: n.toCharArray()){
            max = (char) Math.max(max, ch);
        }

        return max - '0';
    }
}