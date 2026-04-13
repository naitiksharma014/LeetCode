class Solution {

    public boolean removeSenate(StringBuilder sb, char ch, int idx) {
        boolean flag = false;

        while(true) {

            if(idx == 0) {      // cycle complete
                flag = true;
            }

            if(sb.charAt(idx) == ch) {
                sb.deleteCharAt(idx);
                break;
            }

            idx = (idx + 1) % sb.length();
        }

        return flag;
    }
    public String predictPartyVictory(String senate) {
        StringBuilder sb = new StringBuilder(senate);

        int R_count = 0;
        int D_count = 0;
        for(char ch: senate.toCharArray()){
            if(ch == 'R') R_count++;
            else D_count++;
        }

        int idx = 0;

        while(R_count > 0 && D_count > 0) {

            if(sb.charAt(idx) == 'R') {
               
                boolean removeFromLeft = removeSenate(sb, 'D', (idx + 1) % sb.length());
                D_count--;

                if(removeFromLeft) {
                    idx--;
                }

            } else {

                boolean removeFromLeft = removeSenate(sb, 'R', (idx + 1) % sb.length());
                R_count--;

                if(removeFromLeft) {
                    idx--;
                }
            }

            idx = (idx + 1) % sb.length();
        }

        return R_count == 0 ? "Dire" : "Radiant";
    }
}