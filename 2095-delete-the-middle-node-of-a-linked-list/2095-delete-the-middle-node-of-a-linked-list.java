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

// TC: O(n)
// SC: O(1)

class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next == null) {
            return null;
        }

        int n = 0;
        ListNode temp = head;

        while(temp != null) {
            n++;
            temp = temp.next;
        }

        temp = head;
        int mid = n / 2;

        while(mid != 1) {
            temp = temp.next;
            mid--;
        }

        temp.next = temp.next.next;

        return head;
    }
}