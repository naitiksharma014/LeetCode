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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }

        int len = 0;

        ListNode temp = head;
        ListNode lastNode = null;

        while(temp != null) {

            if(temp.next == null) {
                lastNode = temp;
            }

            len++;
            temp = temp.next;
        }

        k = k % len;

        if (k == 0) {
            return head;
        }

        int move = len - k - 1;
        temp = head;

        while(move--> 0) {
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;
        lastNode.next = head;

        return newHead;
    }
}