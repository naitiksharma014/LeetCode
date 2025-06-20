/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;

        while( temp != null ){
            list.add( temp.val );
            temp = temp.next;
        }

        int n = list.size();
        int i = 0 , j = n-1;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        while( i < j ){
            sum = list.get(i) + list.get(j);
            max = Math.max( max , sum );
            
            i++;
            j--;
        }

        return max;
    }
}