class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int[] res = new int[2];

        for(int i = 0 ; i < n ; i++){
            count[nums[i]]++;
        }
        
        int j = 0;
        for(int i = 0 ; i < n ; i++){
            if(count[i] == 2){
                res[j] = i;
                j++;
            }
        }

        return res;
    }
}