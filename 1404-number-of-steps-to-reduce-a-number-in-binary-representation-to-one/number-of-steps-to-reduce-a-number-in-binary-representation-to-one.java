class Solution {
    public String addOne(String s){
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        int i = n - 1;
        
        // To add one : flip 1 → 0 until we find 0 and flip 0 → 1
        while(i >= 0 && sb.charAt(i) == '1'){
            sb.setCharAt(i, '0');
            i--;
        }

        if(i >= 0){
            sb.setCharAt(i, '1');
        } else {
            sb.insert(0, '1'); // overflow case
        }

        return sb.toString();
    }

    public int numSteps(String s) {
        int steps = 0;

        while(s.length() > 1){
              
            int n = s.length();
            
            // Even -> LSB(rightmost) == 0
            if(s.charAt(n - 1) == '0'){

                s = s.substring(0, n - 1);  // Divide by 2 -> remove 0 at LSB 
            }
            
            // Odd -> LSB(rightmost) == 1
            else{
                s = addOne(s);
            }

            steps++;
        }

        return steps;
    }
}