// 2 Pointer Approach
// TC: O(n)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;

        int[] ans = new int[2];
        int i = 0, j = n - 1;

        while(i < n && j >= 0) {

            if(numbers[i] + numbers[j] == target) {
                ans[0] = i + 1;
                ans[1] = j + 1;

                return ans;
            }
            else if(numbers[i] + numbers[j] < target) {
                i++;
            }
            else {
                j--;
            }
        }

        return ans;
    }
}