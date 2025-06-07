class Solution {
    public int compress(char[] chars) {
        int n = chars.length;

        int i = 0;
        int ind = 0;

        while(i<n){
            char curr = chars[i];
            int count = 0;

            // Find count of duplicates
            while(i<n && chars[i] == curr){
                i++;
                count++;
            }

            // Assign it to chars and move index ahead to add the count
            chars[ind++] = curr;

            // Add the count
            if(count>1){
                String countStr = Integer.toString(count);
                for(char ch : countStr.toCharArray()){
                    chars[ind++] = ch;
                }
            }
            
        }

        return ind;
    }
}