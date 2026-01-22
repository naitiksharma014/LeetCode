class Solution {
    public int minPairSum(ArrayList<Integer> list){
        int index = -1;
        int minSum = Integer.MAX_VALUE;

        for(int i = 0; i < list.size() - 1; i++){
            int sum = list.get(i) + list.get(i + 1);
            
            if(sum < minSum){
                index = i;
                minSum = sum;
            }
        }

        return index;
    }
    private boolean isSorted(ArrayList<Integer> list){
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) > list.get(i + 1)){
                return false;
            }
        }

        return true;
    }
    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        int operation = 0;

        ArrayList<Integer> list = new ArrayList<>(n);

        for(int i = 0; i < n; i++){
            list.add(nums[i]);
        }

        while(!isSorted(list)){

            int index = minPairSum(list);
            
            int merged = list.get(index) + list.get(index + 1);

            list.set(index, merged);
            list.remove(index + 1);

            operation++;
        }

        return operation;
    }
}