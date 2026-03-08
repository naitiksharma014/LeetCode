// Diagonalization Technique
// TC: O(n)

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){

            char ch = nums[i].charAt(i);

            if(ch == '0'){
                sb.append('1');
            } else {
                sb.append('0');
            }
        }

        return sb.toString();
    }
}