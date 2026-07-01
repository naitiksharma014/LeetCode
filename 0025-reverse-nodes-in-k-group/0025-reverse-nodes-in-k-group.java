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

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }

        // Check if head has k nodes or not
        int count = 0;
        ListNode temp = head;

        while(count < k) {

            if(temp == null) {
                return head;
            }

            temp = temp.next;
            count++;
        }

        // Recursion call for temp.next
        ListNode prevNode = reverseKGroup(temp, k);

        // Reverse current group
        temp = head;
        count = 0;

        while(count < k) {

            ListNode next = temp.next;
            temp.next = prevNode;

            prevNode = temp;
            temp = next;

            count++;
        }

        return prevNode;
    }
}