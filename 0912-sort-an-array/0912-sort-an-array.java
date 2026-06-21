// TC: O(n * logn)
// SC: O(n)

class Solution {
    int n;

    public void merge(int[] nums, int start, int mid, int end) {
        List<Integer> temp = new ArrayList<>();

        int i = start, j = mid + 1;

        while(i <= mid && j <= end) {

            if(nums[i] < nums[j]) {
                temp.add(nums[i++]);
            } else {
                temp.add(nums[j++]);
            }
        }

        while(i <= mid) {
            temp.add(nums[i++]);
        }
        

        while(j <= end) {
            temp.add(nums[j++]);
        }

        for(int idx = 0; idx < temp.size(); idx++) {
            nums[idx + start] = temp.get(idx);
        }
    }

    public void mergeSort(int[] nums, int start, int end) {

        if(start < end) {
            
            int mid = start + (end - start) / 2;

            mergeSort(nums, start, mid);
            mergeSort(nums, mid + 1, end);

            merge(nums, start, mid, end);
        }
    }
    public int[] sortArray(int[] nums) {
        n = nums.length;

        mergeSort(nums, 0, n - 1);

        return nums;
    }
}