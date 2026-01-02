class Solution {
    public int repeatedNTimes(int[] nums) {
        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();

        for(int num: nums){

            if(set.contains(num)){
                return num;
            }
            set.add(num);

            //if (!set.add(num)) return num;   simple code in one line
        }

        return -1;
    }
}