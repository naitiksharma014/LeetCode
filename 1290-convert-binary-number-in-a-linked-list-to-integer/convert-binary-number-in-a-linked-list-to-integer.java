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
    public int getDecimalValue(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while( curr != null ){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head = prev;
        int result = 0;
        int pow = 0;
        
        while( head != null ){
            int t = head.val;
            result += t * Math.pow( 2 , pow );
            pow++;
            head = head.next;
        }
        return result;
    }
}