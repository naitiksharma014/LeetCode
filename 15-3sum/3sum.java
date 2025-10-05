class Solution {
    public void twoSum(int[] nums , int k , int target , ArrayList<List<Integer>> res){ 
        int n = nums.length;
        int i = k;
        int j = n - 1;

        while(i < j){

            if(nums[i] + nums[j] > target) j--;
            else if(nums[i] + nums[j] < target) i++;
            else{
                res.add(Arrays.asList(- target , nums[i] , nums[j]) );

                while(i < j && nums[i] == nums[i + 1]) i++;
                while(i < j && nums[j] == nums[j - 1]) j--;

                i++;
                j--;
            }
        }
    }
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        
        if(n < 3) return new ArrayList<>();
        
        ArrayList<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0 ; i < n - 1 ; i++){

            if(i != 0 && nums[i] == nums[i - 1]) continue;
            int target = nums[i];

            twoSum(nums , i + 1 , - target , res);
        }

        return res;
    }
}