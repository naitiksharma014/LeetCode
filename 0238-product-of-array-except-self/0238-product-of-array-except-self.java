class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        int p = 1, zeroCount = 0;

        for(int num: nums) {

            if(num != 0) {
                p *= num;
            }
            else {
                zeroCount++;
            }
        }

        for(int i = 0; i < n; i++) {
            
            if(zeroCount > 1) {
                res[i] = 0;
            }
            else if(zeroCount == 1) {

                if(nums[i] == 0) {
                    res[i] = p;
                } else {
                    res[i] = 0;
                }
            }
            else {
                res[i] = p / nums[i];
            }
        }

        return res;
    }
}