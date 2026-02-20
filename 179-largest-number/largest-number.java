class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
       
        // int[] -> String[]
        String[] str = new String[n];
        for(int i = 0; i < n; i++){
            str[i] = String.valueOf(nums[i]);  // Int to String
        }

        // sort string[] using lambda function
        Arrays.sort(str,
            (s1, s2) -> (s2 + s1).compareTo(s1 + s2)
        );


        // Edge case
        if (str[0].equals("0")) return "0";
        

        // String[] -> String
        StringBuilder sb = new StringBuilder();
        for(String s: str){
            sb.append(s);
        }

        return sb.toString();
    }
}