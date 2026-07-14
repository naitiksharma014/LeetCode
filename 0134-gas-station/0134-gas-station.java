// TC: O(n)

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int start = 0;
        int currGas = 0;
        int totalGas = 0;
        int totalCost = 0;

        for(int i = 0; i < n; i++) {

            totalGas += gas[i];
            totalCost += cost[i];

            currGas += (gas[i] - cost[i]);

            if(currGas < 0) {
                start = i + 1;
                currGas = 0;
            }
        }

        return totalGas < totalCost ? -1 : start;
    }
}