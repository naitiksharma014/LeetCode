class Solution {
    public int binaryGap(int n) {
        String binary = Long.toBinaryString(n);

        int gap = 0;
        int prev = 0;

        for(int i = 0; i < binary.length(); i++){

            int curr = i;

            if(binary.charAt(curr) == '1'){
                gap = Math.max(gap, curr - prev);
                prev = curr;
            }
        }

        return gap;
    }
}