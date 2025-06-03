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
    public ListNode removeElements(ListNode head, int val) {
     ListNode temp=head;

     if(head==null ){
        return null;
     }

     if(head.val!=val && head.next==null){
        return head;

     }

     


     while(temp.next!=null ){
     
        if(temp.next.val==val){
            temp.next=temp.next.next;

        }
        else {
            temp=temp.next;
        }

        // if(temp.val==val){
        //     return null;
        // }
     }
     if(head.val==val){
        head=head.next;
     }
     return head;

    }
}