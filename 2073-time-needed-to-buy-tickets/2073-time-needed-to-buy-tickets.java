/*
Approach - 1: Brute Force

TC: O(n * k)
Sc: O(1)

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int time = 0, i = 0;

        while(i < n && tickets[k] > 0) {

            if(tickets[k] == 0) {
                return time;
            }

            if(tickets[i] > 0) {
                tickets[i] -= 1;
                time++;
            }

            i = (i + 1) % n;
        }

        return time;
    }
}
*/

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int time = 0;

        for(int i = 0; i < n; i++) {

            if(i <= k) {
                time += Math.min(tickets[i], tickets[k]);
            } else {
                time += Math.min(tickets[i], tickets[k] - 1);
            }
        }

        return time;
    }
}