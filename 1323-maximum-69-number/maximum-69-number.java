class Solution {
    public int maximum69Number(int num) {
        String s = Integer.toString(num);
        StringBuilder str = new StringBuilder(s);

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '6') {
                str.setCharAt(i, '9');
                break;
            }
        }

        return Integer.parseInt(str.toString());
    }
}