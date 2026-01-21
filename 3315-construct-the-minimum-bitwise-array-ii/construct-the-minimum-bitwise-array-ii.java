class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){

            if(nums.get(i) % 2 == 0){
                ans[i] = -1;
                continue;
            }

            for(int j = 0; j < 32; j++){
                
                // Skip set bits(1)
                if((nums.get(i) &  1<< j) > 0) continue;
                
                // when first 0 is found, make prev bit to 0
                int prev = j - 1;  // prev bit

                // make prev to 0
                int x = nums.get(i) ^ (1 << (j - 1));

                ans[i] = x;
                break;
            }
        }

        return ans;
    }
}