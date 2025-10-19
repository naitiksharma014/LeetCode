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
    public ListNode deleteMiddle(ListNode head) {
        if(head == null || head.next == null) return null;

        int n = 0;

        ListNode temp = head;
        while(temp != null){
            n++;
            temp = temp.next;
        }
        temp = head;
         if(n < 2){
            head.next = null;
            return head;
        }
        n = n / 2;
        System.out.print(n);
       
        while(n != 1 ){
           temp = temp.next;
           n--;
        }
        temp.next = temp.next.next;
        
        return head;
    }
}