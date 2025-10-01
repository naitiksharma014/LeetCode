class Solution {
    public int searchInsert(int[] nums, int target) {
        int s = 0 , e = nums.length - 1 , mid = 0;

        while(s <= e){

            mid = s + ( e - s) / 2;

            if(nums[mid] == target) return mid;
            if(nums[mid] > target) e = mid - 1;
            if(nums[mid] < target) s = mid + 1;
        }
        return s;
    }
}