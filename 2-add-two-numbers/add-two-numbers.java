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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode prev = null;
        int carry = 0;

        while(temp1 != null || temp2 != null){

            int t1 = (temp1 != null) ? temp1.val : 0;
            int t2 = (temp2 != null) ? temp2.val : 0;

            int sum = t1 + t2 + carry;

            carry = sum / 10;
            int rem = sum % 10;

            if(temp1 != null){
                temp1.val = rem;
                prev  = temp1;
                temp1 = temp1.next;
            }
            else{
                prev.next = new ListNode(rem);
                prev = prev.next;
            }

            if(temp2 != null){
                temp2 = temp2.next;
            }
        }

        if(carry > 0){
            prev.next = new ListNode(carry);
        }
        
        return l1;
    }
}