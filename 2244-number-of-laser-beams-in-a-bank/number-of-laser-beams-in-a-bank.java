class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        
        int prevDevice = 0;
        int result = 0;

        for(int i = 0 ; i < n; i++){

            int currDevice = 0;

            for(char ch : bank[i].toCharArray()){
                if(ch == '1'){
                    currDevice++;
                }
            }

            result += (prevDevice * currDevice);

            if(currDevice != 0){
                prevDevice = currDevice;
            }
        }

        return result;
    }
}