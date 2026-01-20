// -------------------------------------------------------------- (APPROACH - 1)--------------------------------------------------------------------------------------
// Brute Force
// O(n * max(nums[i])


class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){

            boolean found = false;

            for(int j = 1; j < nums.get(i); j++){

                if( (j | (j + 1)) == nums.get(i)){
                    ans[i] = j;
                    found = true;
                    break;
                }
            }

            if(!found){
                ans[i] = -1;
            }
        }

        return ans;
    }
}


// -------------------------------------------------------------- (APPROACH - 2)--------------------------------------------------------------------------------------
// Optimal
// O(n * 32) = O(n)



class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){

            if(nums.get(i) % 2 == 0){
                ans[i] = -1;
                continue;
            }

            for(int j = 1; j < 32; j++){

                // Skip set bits(1) to get 0
                if((nums.get(i) & (1 << j)) > 0){
                    continue;
                }

                int prev = j - 1;

                // Make prev to 0: use XOR
                int x = nums.get(i) ^ (1 << (j - 1));

                ans[i] = x;
                break;
            }
        }

        return ans;
    }
}
