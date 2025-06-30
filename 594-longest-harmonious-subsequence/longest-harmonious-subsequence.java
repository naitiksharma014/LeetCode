class Solution {
    public int findLHS(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for( int i=0 ; i<n ; i++ ){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

        }

        for( int i=0 ; i<n ; i++ ){
            int minNum = nums[i];
            int maxNum = nums[i] + 1;

            if( map.containsKey( maxNum ) ){
                result = Math.max( result , map.get(minNum) + map.get(maxNum) );
            }
        }
        return result;
    }
}