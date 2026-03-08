//---------------------------------------------------------------------------------------(Approach - 1)----------------------------------------------------------------------------------------------------------------------
// Brute Force
//T.C : O(n^2) - Iterating on each string and converting each character to integer
//S.C : O(n) - Using set

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (String num : nums) {
            set.add(Integer.parseInt(num, 2));
        }
        
        int n = nums.length;
        
        String result = "";
        
        for (int number = 0; number <= n; number++) {
            if (!set.contains(number)) {
                result = Integer.toBinaryString(number);
                while (result.length() < n) { //to make till length n
                    result = "0" + result;
                }

                return result;
            }
        }
        
        return "";
    }
}

//---------------------------------------------------------------------------------------(Approach - 2)----------------------------------------------------------------------------------------------------------------------
// Optimal: Diagonalization Technique
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
